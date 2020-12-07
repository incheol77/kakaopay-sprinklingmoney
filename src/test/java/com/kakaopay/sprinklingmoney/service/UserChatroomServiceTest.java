package com.kakaopay.sprinklingmoney.service;

import com.kakaopay.sprinklingmoney.domain.Chatroom;
import com.kakaopay.sprinklingmoney.domain.User;
import com.kakaopay.sprinklingmoney.repository.UserChatroomRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserChatroomServiceTest {

    @Autowired UserChatroomService userChatroomService;
    @Autowired UserChatroomRepository userChatroomRepository;

    @Test
    public void testAddUserToChatroom() throws Exception {
        // given
        User testUser = new User();
        Chatroom testChatroom = new Chatroom();

        // when
        Long userChatroomId = userChatroomService.addUserToChatroom(testUser, testChatroom);

        // then
        Assertions.assertThat(userChatroomId).isEqualTo(
                userChatroomRepository.findOne(userChatroomId).getUserChatroomId());
    }
}