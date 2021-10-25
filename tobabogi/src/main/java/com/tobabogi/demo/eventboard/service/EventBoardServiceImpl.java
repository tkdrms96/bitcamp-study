package com.tobabogi.demo.eventboard.service;


import com.tobabogi.demo.common.dto.PageRequestDTO;
import com.tobabogi.demo.common.dto.PageResponseDTO;
import com.tobabogi.demo.eventboard.domain.EventBoard;
import com.tobabogi.demo.eventboard.dto.EventBoardDTO;
import com.tobabogi.demo.eventboard.dto.EventRemoveDTO;
import com.tobabogi.demo.eventboard.mapper.EventBoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Log4j2

public class EventBoardServiceImpl implements EventBoardService {

    private final EventBoardMapper eventBoardMapper;


    @Override
    public Long register(EventBoardDTO eventboardDTO) {

        log.warn("--------------------------");
        log.warn("register (service)");
        log.warn("--------------------------");

        EventBoard board = eventboardDTO.getDomain();

        eventBoardMapper.insert(board);

        Long bno = board.getEnbno_id();

        board.getAttachList().forEach(EventBoardAttach -> {
            EventBoardAttach.setBno(bno);
            eventBoardMapper.insertAttach(EventBoardAttach);
        });


        return board.getEnbno_id();
    }

    @Override
    public PageResponseDTO<EventBoardDTO> getDTOList(PageRequestDTO pageRequestDTO) {
        log.warn("--------------------------");
        log.warn("getTOList  (service)");
        log.warn("--------------------------");

        List<EventBoardDTO> dtoList = eventBoardMapper.getList(pageRequestDTO).stream()
                .map(EventBoard -> EventBoard.getDTO()).collect(Collectors.toList());

        log.warn("여기도 한번 찾아보시오");
        log.warn(dtoList);
        int count = eventBoardMapper.getCount(pageRequestDTO);

        PageResponseDTO<EventBoardDTO> pageResponseDTO = PageResponseDTO.<EventBoardDTO>builder()
                .dtoList(dtoList)
                .count(count)
                .build();

        return pageResponseDTO;
    }

    @Override
    public EventBoardDTO read(Long enbno_id) {

        log.warn("--------------------------");
        log.warn("read  (service)");
        log.warn("--------------------------");

        EventBoard eventboard = eventBoardMapper.select(enbno_id);

        if (eventboard != null) {
            eventBoardMapper.hitsUpdate(enbno_id); // Eventboard가 있으면 조회수가 1씩 늘어나는 쿼리
            return eventboard.getDTO();
        }
        return null;
    }

    @Override
    public int remove(EventRemoveDTO eventRemoveDTO) {
        log.warn("--------------------------");
        log.warn("remove  (service)");
        log.warn("--------------------------");
        eventRemoveDTO = EventRemoveDTO.builder()
                .enbno_id(eventRemoveDTO.getEnbno_id())
                .isDelete(true)
                .build();

        return eventBoardMapper.remove(eventRemoveDTO);
    }

    @Override
    public boolean modify(EventBoardDTO eventBoardDTO) {
        log.warn("--------------------------");
        log.warn("modify  (service)");
        log.warn("--------------------------");
        eventBoardMapper.deleteAttach(eventBoardDTO.getEnbno_id());

        EventBoard eventboard = eventBoardDTO.getDomain();

        Long bno = eventboard.getEnbno_id();

        eventboard.getAttachList().forEach(EventBoardAttach -> {
            EventBoardAttach.setBno(bno);
            eventBoardMapper.insertAttach(EventBoardAttach);
        });

        return eventBoardMapper.update(eventboard) > 0;
    }
}
