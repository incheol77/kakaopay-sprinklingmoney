package com.kakaopay.sprinklingmoney.service;

import com.kakaopay.sprinklingmoney.domain.Chatroom;
import com.kakaopay.sprinklingmoney.repository.ChatroomRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ChatroomServiceTest {

    @Autowired ChatroomService chatroomService;
    @Autowired ChatroomRepository chatroomRepository;

    /**
     * 대화방 등록 테스트
     */
    @Test
    public void testResisterChatroom() throws Exception {
        // given
        Chatroom chatroom = new Chatroom();
        String testChatroomName = "테스트 대화방1";
        chatroom.setChatroomName(testChatroomName);
        List<Chatroom> chatrooms = new ArrayList<>();
        chatrooms.add(chatroom);

        // when
        chatroomService.register(chatroom);

        // then
        Assertions.assertThat(chatrooms)
                .isEqualTo(chatroomRepository.findByChatroomName(testChatroomName));
    }
}