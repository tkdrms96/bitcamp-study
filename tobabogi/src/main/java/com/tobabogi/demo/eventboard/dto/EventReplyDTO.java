package com.tobabogi.demo.eventboard.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventReplyDTO {
    private Long encno_id; // 원 댓글의 번호
    private String comment; // 댓글 내용

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate; //게시날짜
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modDate; // 수정날짜

    private Long enbno_id; // 원 게시글의 번호
    private boolean isdelete; // 삭제 여부
    private String tbl_member_id;


    private Long level; // 계층 ( 부모댓글 +1 하는것 )
    private Long sequence; //순서 ( 부모 댓글의 순서 +1 )
    private Long parent; //부모 댓글 (대댓글에서 지정해줘야 하는 기준점)

}
