package com.tobabogi.demo.noticeboard.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeUploadResponseDTO {


    private String nano_id; // uuid임
    private String fileName; //원본 파일 이름
    private String img_thumbnail_name; // 썸네일 파일 이름
    private Long tbl_notice_nbno_id; // fk걸려있는bno id
    private LocalDateTime regDate; // 날짜
    private String Path; // 경로 위치
    private boolean isImage; // 이미지인지?
    private boolean isDelete; // 삭제된건가?

    public String getThumbnail(){
        return Path+"/s_"+nano_id+"_"+fileName;
    }
    public String getFileLink(){
        return Path+"/"+nano_id+"_"+fileName;
    }
}
