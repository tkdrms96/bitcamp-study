package com.tobabogi.demo.eventboard.service;

import com.tobabogi.demo.common.dto.PageRequestDTO;
import com.tobabogi.demo.common.dto.PageResponseDTO;
import com.tobabogi.demo.eventboard.dto.EventBoardDTO;
import com.tobabogi.demo.eventboard.dto.EventRemoveDTO;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface EventBoardService {

    Long register(EventBoardDTO eventboardDTO);

    PageResponseDTO<EventBoardDTO> getDTOList(PageRequestDTO pageRequestDTO);

    EventBoardDTO read(Long enbno_id);

    int remove(EventRemoveDTO eventRemoveDTO);

    boolean modify(EventBoardDTO boardDTO);
}
