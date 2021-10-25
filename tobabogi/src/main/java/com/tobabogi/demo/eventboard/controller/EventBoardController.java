package com.tobabogi.demo.eventboard.controller;


import com.tobabogi.demo.common.dto.PageMaker;
import com.tobabogi.demo.common.dto.PageRequestDTO;
import com.tobabogi.demo.common.dto.PageResponseDTO;
import com.tobabogi.demo.eventboard.dto.EventBoardDTO;
import com.tobabogi.demo.eventboard.dto.EventRemoveDTO;
import com.tobabogi.demo.eventboard.dto.EventReplyListDTO;
import com.tobabogi.demo.eventboard.service.EventBoardService;
import com.tobabogi.demo.eventboard.service.EventReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/eventboard/*")
@Log4j2
@RequiredArgsConstructor
public class EventBoardController {



    private final EventBoardService eventBoardService;
    private final EventReplyService eventReplyService;


    @GetMapping("/register")
    public void registerGet() {
        log.warn("--------------------------");
        log.warn("registerGet  (Controller)");
        log.warn("--------------------------");
    }


    @PostMapping("/register")
    public String registerPost(EventBoardDTO eventBoardDTO, RedirectAttributes redirectAttributes){
        log.warn("--------------------------");
        log.warn("registerPost  (Controller)");
        log.warn("--------------------------");

        Long enbno_id = eventBoardService.register(eventBoardDTO);

        redirectAttributes.addFlashAttribute("result", enbno_id); //RedirectAttributes 리다이렉트시 데이터를 전달하고싶을때 사용함

        return "redirect:/eventboard/list";
    }

    //리스트에는 권한이 없다.
    @GetMapping("/list")
    public void getList(PageRequestDTO pageRequestDTO, Model model){
        log.warn("--------------------------");
        log.warn("getList  (Controller)");
        log.warn("--------------------------");
        PageResponseDTO<EventBoardDTO> responseDTO = eventBoardService.getDTOList(pageRequestDTO);

        model.addAttribute("dtoList", responseDTO.getDtoList());

        int total = responseDTO.getCount();
        int page = pageRequestDTO.getPage();
        int size = pageRequestDTO.getSize();

        model.addAttribute("pageMaker", new PageMaker(page,size,total));

    }



    @GetMapping(value = {"/read"})
    public void read(Long enbno_id, PageRequestDTO pageRequestDTO, Model model, EventReplyListDTO eventReplyListDTO){
        log.warn("--------------------------");
        log.warn("read  (Controller)");
        log.warn("--------------------------");


        model.addAttribute("eventReplyDTO", eventReplyService.getRepliesWithBno(eventReplyListDTO));

        model.addAttribute("eventBoardDTO", eventBoardService.read(enbno_id));

    }

    @GetMapping(value = {"/modify"})
    public void modifyRead(Long enbno_id,PageRequestDTO pageRequestDTO, Model model){

        log.warn("--------------------------");
        log.warn("modifyRead  (Controller)");
        log.warn("--------------------------");


        model.addAttribute("eventBoardDTO", eventBoardService.read(enbno_id));

    }

    @PostMapping("/modify")
    public String modify(EventBoardDTO eventBoardDTO, PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes){

        log.warn("--------------------------");
        log.warn("modify  (Controller)");
        log.warn("--------------------------");
        if(eventBoardDTO.getFiles().size() > 0){
            eventBoardDTO.getFiles().forEach(dto -> log.info(dto));
        }

        if(eventBoardService.modify(eventBoardDTO)){
            redirectAttributes.addFlashAttribute("result","modified");
        }

        redirectAttributes.addAttribute("enbno_id", eventBoardDTO.getEnbno_id());
        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());

        if(pageRequestDTO.getType() != null){
            redirectAttributes.addAttribute("type", pageRequestDTO.getType());
            redirectAttributes.addAttribute("keyword", pageRequestDTO.getKeyword());
        }

        return "redirect:/eventboard/read";
    }

    @PostMapping("/remove")
    public String remove(EventRemoveDTO eventRemoveDTO, RedirectAttributes redirectAttributes){

        log.warn("--------------------------");
        log.warn("remove  (Controller)");
        log.warn("--------------------------");

        eventBoardService.remove(eventRemoveDTO);
        redirectAttributes.addFlashAttribute("result", "success");

        return "redirect:/eventboard/list";

    }
}
