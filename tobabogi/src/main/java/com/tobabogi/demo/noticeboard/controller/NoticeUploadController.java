package com.tobabogi.demo.noticeboard.controller;

import com.tobabogi.demo.noticeboard.dto.NoticeUploadResponseDTO;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@Log4j2
@RequestMapping("/noticeboard/*")
public class NoticeUploadController {


    @GetMapping("/downFile")
    public ResponseEntity<byte[]> download(@RequestParam("file")String fileName)throws Exception{
        log.info("---------------------------------");
        log.info("NoticeUploadController download");
        log.info("---------------------------------");

        File file = new File("C:\\upload"+ File.separator+fileName);

        String NoticeOriginalFileName = fileName.substring(fileName.indexOf("_") +1);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/octet-stream");
        headers.add("Content-Disposition", "attachment; filename="
                + new String(NoticeOriginalFileName.getBytes(StandardCharsets.UTF_8),"ISO-8859-1") );
        byte[] data = FileCopyUtils.copyToByteArray(file);

        return ResponseEntity.ok().headers(headers).body(data);
    }

    @GetMapping("/viewFile")
    @ResponseBody
    public ResponseEntity<byte[]> viewFile(@RequestParam("file") String fileName) throws Exception{
        log.info("---------------------------------");
        log.info("NoticeUploadController viewFile");
        log.info("---------------------------------");


        File file = new File("C:\\upload" + File.separator+fileName);

        ResponseEntity<byte[]> result = null;

        byte[] data = FileCopyUtils.copyToByteArray(file);

        //mime type
        String mimeType = Files.probeContentType(file.toPath());

        result = ResponseEntity.ok().header("Content-Type", mimeType).body(data);

        return result;

    }

    @ResponseBody
    @PostMapping("/upload")
    public List<NoticeUploadResponseDTO> uploadPost(MultipartFile[] uploadFiles){
        log.info("---------------------------------");
        log.info("NoticeUploadController uploadPost");
        log.info("---------------------------------");

        log.info("-----------------------------");
        if(uploadFiles != null && uploadFiles.length > 0){

            List<NoticeUploadResponseDTO> uploadedList = new ArrayList<>();

            for (MultipartFile multipartFile : uploadFiles) {
                try {
                    uploadedList.add(uploadProcess(multipartFile));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }//for
            return uploadedList;

        }//end
        return null;

    }

    private NoticeUploadResponseDTO uploadProcess(MultipartFile multipartFile)throws Exception {
        log.info("---------------------------------");
        log.info("NoticeUploadController uploadProcess");
        log.info("---------------------------------");

        String path ="C:\\upload"; //mac

//        브라우저에서 c드라이브가 나오면안됨

        String folderName = makeFolder(path); // 2021-09-07
        String fileName = multipartFile.getOriginalFilename();
        String nano_id = UUID.randomUUID().toString();
        String originalFileName = fileName;

        fileName = nano_id +"_"+fileName;

        File NoticeSavedFile = new File(path+File.separator+folderName, fileName);

        FileCopyUtils.copy(multipartFile.getBytes(), NoticeSavedFile);

        //Thumbnail 처리
        String mimeType = multipartFile.getContentType();
        boolean checkImage = mimeType.startsWith("image");

        if(checkImage){
            File NoticeThumbnailFile = new File(path+File.separator+folderName, "s_"+fileName);
            Thumbnailator.createThumbnail(NoticeSavedFile,NoticeThumbnailFile,300,300);
        }

        return NoticeUploadResponseDTO.builder()
                .nano_id(nano_id)
                .Path(folderName.replace(File.separator,"/"))
                .img_thumbnail_name(folderName.replace(File.separator,"/")+"/s_"+fileName)
                .fileName(originalFileName)
                .isImage(checkImage)
                .build();
    }

    private String makeFolder(String Path) {
        log.info("---------------------------------");
        log.info("NoticeUploadController makeFolder");
        log.info("---------------------------------");

        SimpleDateFormat NoticeSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String str = NoticeSimpleDateFormat.format(date); //2021-09-07
        String folderName = str.replace("-", File.separator); //win \\ mac /
        File uploadFolder = new File(Path, folderName);
        if(uploadFolder.exists() == false){
            uploadFolder.mkdirs();
        }
        return folderName;
    }
}