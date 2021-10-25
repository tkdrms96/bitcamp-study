package com.tobabogi.demo.eventboard.mapper;

import com.tobabogi.demo.common.dto.PageRequestDTO;
import com.tobabogi.demo.eventboard.domain.EventBoard;
import com.tobabogi.demo.eventboard.domain.EventBoardAttach;
import com.tobabogi.demo.eventboard.dto.EventRemoveDTO;

import java.util.List;

public interface EventBoardMapper {


    void insert(EventBoard eventboard); // 게시글 등록하기

    List<EventBoard> getList(PageRequestDTO pageRequestDTO); // List페이지에서 게시글 뿌려주기

    int getCount(PageRequestDTO pageRequestDTO); // insert한 마지막숫자 가지고오기

    EventBoard select(Long enbno_id); // select 하는것

    int remove(EventRemoveDTO eventRemoveDTO); //delete 없음  isdelete = 삭제되면 true로 바꿔야함

    int update(EventBoard eventboard); //게시글 수정 쿼리

    int hitsUpdate(Long bno); //게시글 read할 시 조회수 update 시켜주는 쿼리




    int insertAttach(EventBoardAttach eventBoardAttach); // 첨부파일 등록 쿼리

    int deleteAttach(Long enbno_id); //첨부파일 삭제 쿼리
}
