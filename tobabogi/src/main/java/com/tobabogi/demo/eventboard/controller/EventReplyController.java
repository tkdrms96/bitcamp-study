package com.tobabogi.demo.eventboard.controller;


import com.tobabogi.demo.common.dto.PageMaker;
import com.tobabogi.demo.common.dto.PageRequestDTO;
import com.tobabogi.demo.common.dto.PageResponseDTO;
import com.tobabogi.demo.eventboard.domain.EventReply;
import com.tobabogi.demo.eventboard.dto.EventReplyDTO;
import com.tobabogi.demo.eventboard.dto.EventReplyListDTO;
import com.tobabogi.demo.eventboard.dto.EventReplyPageResponseDTO;
import com.tobabogi.demo.eventboard.service.EventReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RestController //@ResponseBody
@RequestMapping("/replies")
@RequiredArgsConstructor
public class EventReplyController {

    private final EventReplyService eventreplyService;

    @PostMapping("")
    public void add(@RequestBody EventReplyDTO eventReplyDTO){

        log.info("==========================");
        log.info("==========================");
        log.info("==========================");
        log.info("==========================");

        eventreplyService.add(eventReplyDTO);
    }

    @PutMapping("/remove/{encno_id}")
    public String remove( @PathVariable(name="encno_id")  Long encno_id ){
        log.info("----------------reply remove------------");


        eventreplyService.remove(encno_id);

        return "success";
    }

    @PutMapping("/{encno_id}")
    public String modify(@PathVariable(name="encno_id")  Long encno_id, @RequestBody EventReplyDTO replyDTO){


        eventreplyService.modify(replyDTO);

        return "success";
    }

    @GetMapping("/list/{enbno_id}") // replies/list/230?page={page}
    public EventReplyPageResponseDTO<EventReplyDTO> getBoardReplies(@PathVariable(name="enbno_id") Long enbno_id ,
                                                                    EventReplyListDTO eventReplyListDTO,
                                                                      PageRequestDTO pageRequestDTO, Model model){

        //서비스 계층 호출
        EventReplyPageResponseDTO<EventReplyDTO> responseDTO = (EventReplyPageResponseDTO<EventReplyDTO>) eventreplyService.getRepliesWithBno(eventReplyListDTO);
        log.warn("여기를 찾아주세요 컨트롤러");
        log.warn(pageRequestDTO);
        log.warn(eventReplyListDTO);
        log.warn(responseDTO);
        log.warn(enbno_id);
//        model.addAttribute("dtoList", responseDTO);
        int total = responseDTO.getCount();
        int page = pageRequestDTO.getPage();
        int size = pageRequestDTO.getSize();

        log.warn(total);
        log.warn(page);
        log.warn(size);

        responseDTO.setPageMaker(new PageMaker(page,size,total));

        return responseDTO;

    }

    @PostMapping("/level")
    public Map<String, String> levelReplyAdd(@RequestBody EventReplyDTO eventReplyDTO){
        log.warn("----------------------------------------------");
        log.warn("c  LevelReplyAdd------------------------------");
        log.warn(eventReplyDTO);


        eventreplyService.levelReplyAdd(eventReplyDTO);

        Map<String, String> result = new HashMap<>();
        result.put("result", "success");

        return result;

    }

}
