package com.tobabogi.demo.eventboard.service;


import com.tobabogi.demo.common.dto.PageRequestDTO;
import com.tobabogi.demo.common.dto.PageResponseDTO;
import com.tobabogi.demo.eventboard.domain.EventReply;
import com.tobabogi.demo.eventboard.dto.EventBoardDTO;
import com.tobabogi.demo.eventboard.dto.EventReplyDTO;
import com.tobabogi.demo.eventboard.dto.EventReplyListDTO;
import com.tobabogi.demo.eventboard.dto.EventReplyPageResponseDTO;
import com.tobabogi.demo.eventboard.mapper.EventBoardMapper;
import com.tobabogi.demo.eventboard.mapper.EventReplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
//@Transactional
public class EventReplyServiceImpl implements EventReplyService{

    private final EventReplyMapper eventReplyMapper;

    @Override
    public void add(EventReplyDTO eventReplyDTO) {

//        댓글달기 ( 답글X).
        log.warn("--------------------------");
        log.warn("add (ReplyService)");
        log.warn("--------------------------");
         eventReplyMapper.insert(dtoToEntity(eventReplyDTO));

         Long encno_id = dtoToEntity(eventReplyDTO).getEncno_id();

         eventReplyMapper.insertKey(encno_id);

    }

    @Override
    public EventReplyPageResponseDTO<EventReplyDTO> getRepliesWithBno(EventReplyListDTO eventReplyListDTO ) {
        //        댓글 List(답글 포함)

        log.warn("--------------------------");
        log.warn("getRepliesWithBno (ReplyService)");
        log.warn("--------------------------");
        log.warn("이유좀 이유좀 이유좀");

        List<EventReplyDTO> dtoList = eventReplyMapper.getListWithBoard(eventReplyListDTO).stream()
                .map(EventReply -> entityToDTO(EventReply)).collect(Collectors.toList());

        log.warn("여기서안되누?");

        int count = eventReplyMapper.replyCount(eventReplyListDTO.getEnbno_id());

        log.warn("여기서안되누2?");

        EventReplyPageResponseDTO<EventReplyDTO> pageResponseDTO = new EventReplyPageResponseDTO<EventReplyDTO>();
        pageResponseDTO.setDtoList(dtoList);
        pageResponseDTO.setCount(count);

        log.warn("여기를 찾아주세요");
        log.warn(count);
        log.warn(dtoList);
        log.warn(pageResponseDTO);

        return pageResponseDTO;
    }

    @Override
    public int remove(Long rno) {
        //        댓글 수정(답글 삭제 포함)

        log.warn("--------------------------");
        log.warn("remove (ReplyService)");
        log.warn("--------------------------");
        return eventReplyMapper.delete(rno);
    }

    @Override
    public int modify(EventReplyDTO eventReplyDTO) {

//        댓글 수정(답글달기 포함)
        log.warn("--------------------------");
        log.warn("modify (ReplyService)");
        log.warn("--------------------------");
        return eventReplyMapper.update(dtoToEntity(eventReplyDTO));
    }

    @Override
    public void levelReplyAdd(EventReplyDTO eventReplyDTO) {

//        답글 달기
        log.warn("--------------------------");
        log.warn("LevelReplyAdd (ReplyService)");
        log.warn("--------------------------");
        eventReplyMapper.levelReplyInsert(dtoToEntity(eventReplyDTO));
    }
}
