package com.tobabogi.demo.eventboard.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventUploadResponseDTO {
    private String uuid; // uuid임
    private String fileName; //원본 파일 이름
    private String img_thumbnail_name; // 썸네일 파일 이름
    private Long tbl_event_notice_board_enbno_id; // fk걸려있는bno id
    private LocalDateTime regDate; // 날짜
    private String Path; // 경로 위치
    private boolean isImage; // 이미지인지?
    private boolean isDelete; // 삭제된건가?

    public String getThumbnail(){
        return Path+"/s_"+uuid+"_"+fileName;
    }
    public String getFileLink(){
        return Path+"/"+uuid+"_"+fileName;
    }


}
