package com.tobabogi.demo.eventboard.domain;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventReply {

    private Long encno_id; // 원 댓글의 번호
    private String comment; // 댓글 내용
    private LocalDateTime regDate; //게시날짜
    private LocalDateTime modDate; // 수정날짜
    private Long enbno_id; // 원 게시글의 번호
    private boolean isdelete; // 삭제 여부
    private String tbl_member_id;



    private Long level; // 계층 ( 부모댓글 +1 하는것 )
    private Long sequence; //순서 ( 부모 댓글의 순서 +1 )
    private Long parent; //부모 댓글 (대댓글에서 지정해줘야 하는 기준점)


}
