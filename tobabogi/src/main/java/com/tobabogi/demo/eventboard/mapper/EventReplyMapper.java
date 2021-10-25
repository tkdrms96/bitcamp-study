package com.tobabogi.demo.eventboard.mapper;


import com.tobabogi.demo.common.dto.PageRequestDTO;
import com.tobabogi.demo.eventboard.domain.EventReply;
import com.tobabogi.demo.eventboard.dto.EventReplyListDTO;

import java.util.List;

public interface EventReplyMapper {

    int insert(EventReply reply); // Reply insert 쿼리

    List<EventReply> getListWithBoard(EventReplyListDTO eventReplyListDTO); // Reply List 쿼리

    int delete(Long enbno_id); // Reply 삭제 쿼리

    int update(EventReply reply); //Reply 수정 쿼ㅣㄹ

    int levelReplyInsert(EventReply reply); // 계층댓글 ( 대댓글) 인설트 쿼리

    int insertKey(Long encno_id);

    int replyCount(Long enbno_id);


}
