package com.tobabogi.demo.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UploadResponseDTO {

    private String uuid;
    private String fileName;
    private boolean image;
    private String uploadPath;
    // get 메서드로 만들어주면 json으로 처리해준다
    public String getThumbnail() {
        return uploadPath+"/s_"+uuid+"_"+fileName;
    }

    public String getFileLink() {
        return uploadPath+"/"+uuid+"_"+fileName;
    }
}
