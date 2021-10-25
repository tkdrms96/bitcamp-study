package com.tobabogi.demo.noticeboard.domain;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NoticeBoardAttach {

    private String fileName;
    private String img_thumbnail_name;
    private String nano_id;
    private Long tbl_notice_nbno_id;
    private LocalDateTime regDate;
    private boolean isImage;
    private boolean isDelete;
    private String Path;

    public void setBno(Long bno){
        this.tbl_notice_nbno_id = bno;
    }
}
