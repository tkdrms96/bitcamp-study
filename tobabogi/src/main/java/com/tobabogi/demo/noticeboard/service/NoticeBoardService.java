package com.tobabogi.demo.noticeboard.service;


import com.tobabogi.demo.common.dto.PageRequestDTO;
import com.tobabogi.demo.common.dto.PageResponseDTO;
import com.tobabogi.demo.noticeboard.dto.NoticeBoardDTO;
import com.tobabogi.demo.noticeboard.dto.NoticeRemoveDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional // 트렌젝션 잠깐 삭제함
public interface NoticeBoardService {

    Long register(NoticeBoardDTO noticeboardDTO);

    PageResponseDTO<NoticeBoardDTO> getDTOList(PageRequestDTO pageRequestDTO);

    NoticeBoardDTO read(Long nbno_id);

    int remove(NoticeRemoveDTO noticeRemoveDTO);

    boolean modify(NoticeBoardDTO boardDTO);


}
