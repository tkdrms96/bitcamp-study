package com.tobabogi.demo.noticeboard.mapper;


import com.tobabogi.demo.common.dto.PageRequestDTO;
import com.tobabogi.demo.noticeboard.domain.NoticeBoard;
import com.tobabogi.demo.noticeboard.domain.NoticeBoardAttach;
import com.tobabogi.demo.noticeboard.dto.NoticeRemoveDTO;

import java.util.List;

public interface NoticeBoardMapper {

    void insert(NoticeBoard noticeboard); // 등록하기

    List<NoticeBoard> getList(PageRequestDTO pageRequestDTO); // List 페이지 가지고오기

    int getCount(PageRequestDTO pageRequestDTO); // 마지막숫자 가지고오기

    NoticeBoard select(Long bno); //select하는것

    int remove(NoticeRemoveDTO noticeRemoveDTO); //delete 없음  isdelete = 삭제되면 true로 바꿔야함

    int update(NoticeBoard noticeboard);

    int hitsUpdate(Long bno);


    int insertAttach(NoticeBoardAttach noticeBoardAttach);

    int deleteAttach(Long nano_id);


}
