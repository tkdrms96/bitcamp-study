package com.tobabogi.demo.common.controller;

import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.tobabogi.demo.common.dto.UploadResponseDTO;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@Log4j2
public class UploadController {

    @ResponseBody
    @PostMapping("/removeFile")
    public ResponseEntity<String> removeFile(@RequestBody Map<String,String> data) throws Exception {
        //2021/09/08
        File file=new File("/Users/include-hoany/upload"+File.separator+data.get("fileName"));
        boolean checkImage=Files.probeContentType(file.toPath()).startsWith("image");
        file.delete();

        if (checkImage) {
            File thumbnail=new File(file.getParent(),"s_"+file.getName());
            log.info(thumbnail);
            thumbnail.delete();
        }
        return ResponseEntity.ok().body("deleted");
    }

    @GetMapping("/downFile")
    public ResponseEntity<byte[]> download(@RequestParam("file") String fileName) throws Exception {
        File file=new File("/Users/include-hoany/upload"+File.separator+fileName);
        String originalFileName=fileName.substring(fileName.indexOf("_")+1);
        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-Type","application/octet-stream");
        headers.add("Content-Disposition","attachment; filename="
                +new String(originalFileName.getBytes(StandardCharsets.UTF_8),"ISO-8859-1"));
        byte[] data=FileCopyUtils.copyToByteArray(file);

        return ResponseEntity.ok().headers(headers).body(data);
    }

    @GetMapping("/sample/upload")
    public void uploadGet() {

    }
    // 이미지 조회하는 코드
    @GetMapping("/viewFile")
    @ResponseBody
    public ResponseEntity<byte[]> viewFile(@RequestParam("file") String fileName) throws IOException { // 보낼때는 file 파라미터를 받을 때는 fileName
        // c:\\upload\\2021\\09\\08\\cat.jpg
        File file=new File("/Users/include-hoany/upload"+File.separator+fileName);
        log.info(file);
        ResponseEntity<byte[]> result=null;
        byte[] data=FileCopyUtils.copyToByteArray(file);

        //mime type
        String mimeType=Files.probeContentType(file.toPath());
        log.info("mimeType : "+mimeType);
        HttpHeaders httpHeaders=new HttpHeaders();
        result=ResponseEntity.ok().header("Content-Type",mimeType).body(data);
        return result;
    }

    @ResponseBody // rest controller 처럼 메서드의 리턴타입이 json
    @PostMapping("/upload")
    public List<UploadResponseDTO> uploadPost(MultipartFile[] uploadFiles) { //uploadFiles 이름이 같아야 함
        log.info("-------------uploadPost-------------------------");

        String uploadPath = "/Users/include-hoany/upload";

        if (uploadFiles != null && uploadFiles.length > 0) {
            List<UploadResponseDTO> uploadedList = new ArrayList<>();
            for (MultipartFile multipartFile : uploadFiles) {
                try {
                    uploadedList.add(uploadProcess(multipartFile));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } // end
            return uploadedList;
        }
        return null;
    }

    private UploadResponseDTO uploadProcess(MultipartFile multipartFile) throws Exception {
        String uploadPath="/Users/include-hoany/upload";
        log.info("-------------uploadProcess-------------------------");
        String folderName=makeFolder(uploadPath); //2021-09-07

        log.info(multipartFile);
        log.info(multipartFile.getContentType());
        log.info(multipartFile.getSize());
        log.info(multipartFile.getOriginalFilename());

        String fileName=multipartFile.getOriginalFilename();
        String uuid=UUID.randomUUID().toString();
        String originalFileName=fileName;
        fileName= uuid+"_"+fileName;
        log.info(fileName);
        File savedFile=new File(uploadPath+File.separator+folderName,fileName);

        FileCopyUtils.copy(multipartFile.getBytes(),savedFile);

        //썸네일 처리
        String mimeType=multipartFile.getContentType();
        boolean checkImgage=mimeType.startsWith("image");

        if (checkImgage) {
            File thumbnailFile=new File(uploadPath+File.separator+folderName,"s_"+fileName);
            Thumbnailator.createThumbnail(savedFile,thumbnailFile,100,100);
        }
        return UploadResponseDTO.builder()
                .uuid(uuid)
                .uploadPath(folderName.replace(File.separator,"/"))
                .fileName(originalFileName)
                .image(checkImgage)
                .build();
    }

    private String makeFolder(String uploadPath) {

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();

        // 2021-09-10
        String str=simpleDateFormat.format(date);
        // 2021\\09\\10
        String folderName=str.replace("-",File.separator); // windows :\\ mac : /
        // c:\\upload, 2021\\09\\10
        File uploadFolder = new File(uploadPath,folderName);

        if (uploadFolder.exists()==false) {
            uploadFolder.mkdirs();
        }
        return folderName;
    }
}
