package com.tobabogi.demo.eventboard;

import com.tobabogi.demo.common.config.RootConfig;
import com.tobabogi.demo.eventboard.domain.EventBoard;
import com.tobabogi.demo.eventboard.mapper.EventBoardMapper;
import com.tobabogi.demo.noticeboard.config.NoticeBoardRootConfig;
import com.tobabogi.demo.noticeboard.domain.NoticeBoard;
import com.tobabogi.demo.noticeboard.mapper.NoticeBoardMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.IntStream;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration( classes = {NoticeBoardRootConfig.class, RootConfig.class})
public class EventBoardMapperTests {

    @Autowired
    EventBoardMapper eventBoardMapper;

//    @Test
//    public void removeTest(){
//
//        NoticeRemoveDTO testDTO = NoticeRemoveDTO.builder()
//                .nbno_id(7)
//                .isdelete(true)
//                .build();
//
//        noticeBoardMapper.remove(testDTO);
//
//    }

    @Test
    public void testdumies() {
        IntStream.rangeClosed(1, 100).forEach(i ->{
            EventBoard board = EventBoard.builder()
                    .title("관리자의 공지사항입니다")
                    .description("안녕하세요 관리자입니다")
                    .build();
            eventBoardMapper.insert(board);

        });

    }
}
