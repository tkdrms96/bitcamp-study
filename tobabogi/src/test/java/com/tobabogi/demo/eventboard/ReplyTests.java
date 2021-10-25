package com.tobabogi.demo.eventboard;

import com.tobabogi.demo.common.config.RootConfig;
import com.tobabogi.demo.eventboard.config.EventBoardRootConfig;
import com.tobabogi.demo.eventboard.domain.EventReply;
import com.tobabogi.demo.eventboard.mapper.EventReplyMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.IntStream;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration( classes = {RootConfig.class, EventBoardRootConfig.class})
public class ReplyTests {

    @Autowired(required = false)
    EventReplyMapper replyMapper;

    @Test
    public void insertDummies() {
        for(int i = 0; i < 100; i++) {
            EventReply reply = EventReply.builder()
                    .enbno_id(117L)
                    .comment("댓글페이징 test")
                    .isdelete(false)
                    .build();

                replyMapper.insert(reply);

            }
    }


//    @Test
////    public void testList() {
////        Long enbno_id = 106L;
////        replyMapper.getListWithBoard(enbno_id).forEach(reply -> log.info(reply));
////    }

}
