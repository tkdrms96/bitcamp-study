package com.tobabogi.demo.eventboard.service;

import com.tobabogi.demo.common.dto.PageRequestDTO;
import com.tobabogi.demo.common.dto.PageResponseDTO;
import com.tobabogi.demo.eventboard.domain.EventReply;
import com.tobabogi.demo.eventboard.dto.EventReplyDTO;
import com.tobabogi.demo.eventboard.dto.EventReplyListDTO;

import java.util.List;

public interface EventReplyService {

    void add(EventReplyDTO eventreplyDTO);

    PageResponseDTO<EventReplyDTO> getRepliesWithBno(EventReplyListDTO eventReplyListDTO);

    int remove(Long rno);

    int modify(EventReplyDTO eventReplyDTO);

    void levelReplyAdd(EventReplyDTO eventReplyDTO);

    default EventReply dtoToEntity(EventReplyDTO dto){
        EventReply eventreply = EventReply.builder()
                .encno_id(dto.getEncno_id())
                .comment(dto.getComment())
                .regDate(dto.getRegDate())
                .modDate(dto.getModDate())
                .enbno_id(dto.getEnbno_id())
                .tbl_member_id(dto.getTbl_member_id())
                .isdelete(dto.isIsdelete())
                .level(dto.getLevel())
                .sequence(dto.getSequence())
                .parent(dto.getParent())
                //                skip 과 size는 실험

                .build();
        return eventreply;
    }


    default EventReplyDTO entityToDTO(EventReply eventreply){
        EventReplyDTO eventReplyDTO = EventReplyDTO.builder()
                .encno_id(eventreply.getEncno_id())
                .comment(eventreply.getComment())
                .regDate(eventreply.getRegDate())
                .modDate(eventreply.getModDate())
                .enbno_id(eventreply.getEnbno_id())
                .tbl_member_id(eventreply.getTbl_member_id())
                .isdelete(eventreply.isIsdelete())
                .level(eventreply.getLevel())
                .sequence(eventreply.getSequence())
                .parent(eventreply.getParent())
//                skip 과 size는 실험

                .build();

        return eventReplyDTO;
    }


}
