package com.tobabogi.demo.eventboard.controller;


import com.tobabogi.demo.eventboard.dto.EventUploadResponseDTO;
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
@RequestMapping("/eventboard/*")
public class EventUploadController {



    @GetMapping("/downFile")
    public ResponseEntity<byte[]> download(@RequestParam("file")String fileName)throws Exception{
        log.info("---------------------------------");
        log.info("EventUploadController download");
        log.info("---------------------------------");

        File file = new File("/Users/include-hoany/upload"+ File.separator+fileName);

        String EventOriginalFileName = fileName.substring(fileName.indexOf("_") +1);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/octet-stream");
        headers.add("Content-Disposition", "attachment; filename="
                + new String(EventOriginalFileName.getBytes(StandardCharsets.UTF_8),"ISO-8859-1") );
        byte[] data = FileCopyUtils.copyToByteArray(file);

        return ResponseEntity.ok().headers(headers).body(data);
    }

    @GetMapping("/viewFile")
    @ResponseBody
    public ResponseEntity<byte[]> viewFile(@RequestParam("file") String fileName) throws Exception{

        log.info("---------------------------------");
        log.info("EventUploadController viewFile");
        log.info("---------------------------------");

        File file = new File("/Users/include-hoany/upload" + File.separator+fileName);

        ResponseEntity<byte[]> result = null;

        byte[] data = FileCopyUtils.copyToByteArray(file);

        //mime type
        String mimeType = Files.probeContentType(file.toPath());

        result = ResponseEntity.ok().header("Content-Type", mimeType).body(data);

        return result;

    }

    @ResponseBody
    @PostMapping("/upload")
    public List<EventUploadResponseDTO> uploadPost(MultipartFile[] uploadFiles){
        log.info("---------------------------------");
        log.info("EventUploadController uploadPost");
        log.info("---------------------------------");
        if(uploadFiles != null && uploadFiles.length > 0){

            List<EventUploadResponseDTO> uploadedList = new ArrayList<>();

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

    private EventUploadResponseDTO uploadProcess(MultipartFile multipartFile)throws Exception {
        log.info("---------------------------------");
        log.info("EventUploadController uploadProcess");
        log.info("---------------------------------");

        String path ="/Users/include-hoany/upload"; //mac

        String folderName = makeFolder(path); // 2021-09-07
        String fileName = multipartFile.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String originalFileName = fileName;

        fileName = uuid +"_"+fileName;

        File eventSavedFile = new File(path+File.separator+folderName, fileName);

        FileCopyUtils.copy(multipartFile.getBytes(), eventSavedFile);

        //Thumbnail 처리
        String mimeType = multipartFile.getContentType();
        boolean checkImage = mimeType.startsWith("image");

        if(checkImage){
            File eventThumbnailFile = new File(path+File.separator+folderName, "s_"+fileName);
            Thumbnailator.createThumbnail(eventSavedFile,eventThumbnailFile,300,300);
        }

        return EventUploadResponseDTO.builder()
                .uuid(uuid)
                .Path(folderName.replace(File.separator,"/"))
                .img_thumbnail_name(folderName.replace(File.separator,"/")+"/s_"+fileName)
                .fileName(originalFileName)
                .isImage(checkImage)
                .build();
    }

    private String makeFolder(String Path) {
        log.info("---------------------------------");
        log.info("EventUploadController makeFolder");
        log.info("---------------------------------");
        SimpleDateFormat EventSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String str = EventSimpleDateFormat.format(date); //2021-09-07
        String folderName = str.replace("-", File.separator); //win \\ mac /
        File uploadFolder = new File(Path, folderName);
        if(uploadFolder.exists() == false){
            uploadFolder.mkdirs();
        }
        return folderName;
    }


}
