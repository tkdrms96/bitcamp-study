package com.tobabogi.demo.noticeboard.controller;

import com.tobabogi.demo.common.dto.PageMaker;
import com.tobabogi.demo.common.dto.PageRequestDTO;
import com.tobabogi.demo.common.dto.PageResponseDTO;
import com.tobabogi.demo.noticeboard.dto.NoticeBoardDTO;
import com.tobabogi.demo.noticeboard.dto.NoticeRemoveDTO;
import com.tobabogi.demo.noticeboard.service.NoticeBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/noticeboard/*")
@Log4j2
@RequiredArgsConstructor
public class NoticeBoardController {

    private final NoticeBoardService noticeBoardService;

    @GetMapping("/register")
    public void registerGet() {
        log.info("---------------------------------");
        log.info("c registerGet");
        log.info("---------------------------------");
    }


    @PostMapping("/register")
    public String registerPost(NoticeBoardDTO noticeBoardDTO, RedirectAttributes redirectAttributes){
        log.info("---------------------------------");
        log.info("c registerPost");
        log.info("---------------------------------");


//        log.info("boardDTOM       " + boardDTO);
        Long nbno_id = noticeBoardService.register(noticeBoardDTO);

        log.info("============c       registerPost===============");

        redirectAttributes.addFlashAttribute("result", nbno_id); //RedirectAttributes 리다이렉트시 데이터를 전달하고싶을때 사용함

        return "redirect:/noticeboard/list";
    }

    //리스트에는 권한이 없다.
    @GetMapping("/list")
    public void getList(PageRequestDTO pageRequestDTO, Model model){
        log.info("---------------------------------");
        log.info("c getList");
        log.info("---------------------------------");
        PageResponseDTO<NoticeBoardDTO> responseDTO = noticeBoardService.getDTOList(pageRequestDTO);

        model.addAttribute("dtoList", responseDTO.getDtoList());

        int total = responseDTO.getCount();
        int page = pageRequestDTO.getPage();
        int size = pageRequestDTO.getSize();

        model.addAttribute("pageMaker", new PageMaker(page,size,total));

    }



    @GetMapping(value = {"/read"})
    public void read(Long nbno_id,PageRequestDTO pageRequestDTO, Model model){
        log.info("---------------------------------");
        log.info("c read");
        log.info("---------------------------------");

        log.info("c   read " + pageRequestDTO);



        model.addAttribute("noticeBoardDTO", noticeBoardService.read(nbno_id));

    }

    @GetMapping(value = {"/modify"})
    public void modifyRead(Long nbno_id,PageRequestDTO pageRequestDTO, Model model){
        log.warn("---------------------------------");
        log.warn("c modifyRead");
        log.warn("---------------------------------");

        log.warn("c   read " + pageRequestDTO);
        log.warn("여기를 찾으시오");
        NoticeBoardDTO noticeBoardDTO = noticeBoardService.read(nbno_id);
        log.warn(noticeBoardDTO);

        model.addAttribute("noticeBoardDTO", noticeBoardService.read(nbno_id));

    }

    @PostMapping("/modify")
    public String modify(NoticeBoardDTO noticeboardDTO, PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes){

        log.info("---------------------------------");
        log.info("c modify");
        log.info("---------------------------------");

        if(noticeboardDTO.getFiles().size() > 0){
            noticeboardDTO.getFiles().forEach(dto -> log.info(dto));
        }

        if(noticeBoardService.modify(noticeboardDTO)){
            redirectAttributes.addFlashAttribute("result","modified");
        }

        redirectAttributes.addAttribute("nbno_id", noticeboardDTO.getNbno_id());
        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());

        if(pageRequestDTO.getType() != null){
            redirectAttributes.addAttribute("type", pageRequestDTO.getType());
            redirectAttributes.addAttribute("keyword", pageRequestDTO.getKeyword());
        }

        return "redirect:/noticeboard/read";
    }

    @PostMapping("/remove")
    public String remove(NoticeRemoveDTO noticeRemoveDTO, RedirectAttributes redirectAttributes){

        log.info("---------------------------------");
        log.info("c remove");
        log.info("---------------------------------");
        noticeBoardService.remove(noticeRemoveDTO);
            redirectAttributes.addFlashAttribute("result", "success");

        return "redirect:/noticeboard/list";

    }


}
