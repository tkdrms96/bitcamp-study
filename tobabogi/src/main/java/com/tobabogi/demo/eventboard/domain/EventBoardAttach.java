package com.tobabogi.demo.eventboard.domain;


import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EventBoardAttach {
    private String fileName;
    private String img_thumbnail_name;
    private String uuid;
    private Long tbl_event_notice_board_enbno_id;
    private LocalDateTime regDate;
    private boolean isImage;
    private boolean isDelete;
    private String Path;

    public void setBno(Long bno){
        this.tbl_event_notice_board_enbno_id = bno;
    }
}
