package com.tobabogi.demo.noticeboard.service;


import com.tobabogi.demo.common.dto.PageRequestDTO;
import com.tobabogi.demo.common.dto.PageResponseDTO;
import com.tobabogi.demo.noticeboard.domain.NoticeBoard;
import com.tobabogi.demo.noticeboard.domain.NoticeBoardAttach;
import com.tobabogi.demo.noticeboard.dto.NoticeBoardDTO;
import com.tobabogi.demo.noticeboard.dto.NoticeRemoveDTO;
import com.tobabogi.demo.noticeboard.mapper.NoticeBoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Log4j2
@RequiredArgsConstructor
public class NoticeBoardServiceImpl implements NoticeBoardService {

    private final NoticeBoardMapper noticeBoardMapper;

    @Override
    public Long register(NoticeBoardDTO noticeboardDTO) {
        log.info("---------------------------------");
        log.info("s register..............");
        log.info("---------------------------------");


        NoticeBoard board = noticeboardDTO.getDomain();

        noticeBoardMapper.insert(board);

        Long bno = board.getNbno_id();

        board.getAttachList().forEach(NoticeBoardAttach -> {
            NoticeBoardAttach.setBno(bno);
            noticeBoardMapper.insertAttach(NoticeBoardAttach);
        });


        return board.getNbno_id();
    }

    @Override
    public PageResponseDTO<NoticeBoardDTO> getDTOList(PageRequestDTO pageRequestDTO) {
        log.info("---------------------------------");
        log.info("s getDTOList..............");
        log.info("---------------------------------");


        List<NoticeBoardDTO> dtoList = noticeBoardMapper.getList(pageRequestDTO).stream().map(NoticeBoard -> NoticeBoard.getDTO()).collect(Collectors.toList());

        int count = noticeBoardMapper.getCount(pageRequestDTO);

        PageResponseDTO<NoticeBoardDTO> pageResponseDTO = PageResponseDTO.<NoticeBoardDTO>builder()
                .dtoList(dtoList)
                .count(count)
                .build();

        return pageResponseDTO;
    }

    @Override
    public NoticeBoardDTO read(Long nbno_id) {
        log.info("---------------------------------");
        log.info("s read..........................");
        log.info("---------------------------------");
        NoticeBoard noticeboard = noticeBoardMapper.select(nbno_id);

        if (noticeboard != null) {
            noticeBoardMapper.hitsUpdate(nbno_id); // noticeboard가 있으면 조회수가 1씩 늘어나는 쿼리
            return noticeboard.getDTO();
        }
        return null;
    }

    @Override
    public int remove(NoticeRemoveDTO noticeRemoveDTO) {
        log.info("---------------------------------");
        log.info("s remove..........................");
        log.info("---------------------------------");

        noticeRemoveDTO = NoticeRemoveDTO.builder()
                .nbno_id(noticeRemoveDTO.getNbno_id())
                .isDelete(true)
                .build();

        return noticeBoardMapper.remove(noticeRemoveDTO);
    }

    @Override
    public boolean modify(NoticeBoardDTO noticeboardDTO) {
        log.info("---------------------------------");
        log.info("s modify..........................");
        log.info("---------------------------------");
        noticeBoardMapper.deleteAttach(noticeboardDTO.getNbno_id());

        NoticeBoard noticeboard = noticeboardDTO.getDomain();

        Long bno = noticeboard.getNbno_id();

        noticeboard.getAttachList().forEach(NoticeBoardAttach -> {
            NoticeBoardAttach.setBno(bno);
            noticeBoardMapper.insertAttach(NoticeBoardAttach);
        });

        return noticeBoardMapper.update(noticeboard) > 0;


    }
}
