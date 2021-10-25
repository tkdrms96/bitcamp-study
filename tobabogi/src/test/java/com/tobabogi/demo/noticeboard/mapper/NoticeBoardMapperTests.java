package com.tobabogi.demo.noticeboard.mapper;

import com.tobabogi.demo.common.config.RootConfig;
import com.tobabogi.demo.noticeboard.config.NoticeBoardRootConfig;
import com.tobabogi.demo.noticeboard.domain.NoticeBoard;
import com.tobabogi.demo.noticeboard.dto.NoticeRemoveDTO;
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
public class NoticeBoardMapperTests {

    @Autowired
    NoticeBoardMapper noticeBoardMapper;

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
            NoticeBoard board = NoticeBoard.builder()
                    .title("관리자의 공지사항입니다")
                    .description("안녕하세요 관리자입니다")
                    .build();
            noticeBoardMapper.insert(board);

        });

    }
}
