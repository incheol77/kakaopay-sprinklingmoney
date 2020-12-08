package com.kakaopay.sprinklingmoney.service;

import com.kakaopay.sprinklingmoney.domain.Chatroom;
import com.kakaopay.sprinklingmoney.domain.User;
import com.kakaopay.sprinklingmoney.domain.UserChatroom;
import com.kakaopay.sprinklingmoney.repository.UserChatroomRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserChatroomServiceTest {

    @Autowired UserChatroomService userChatroomService;
    @Autowired UserChatroomRepository userChatroomRepository;
    @Autowired EntityManager em;

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

    @Test
    @Rollback(false)
    public void testRequestSprinkleMoney() throws Exception {
        // given
        long initAmount = 10000;
        User user = new User();
        user.setUserNickname("슈퍼맨");
        user.setMoneyAmount(initAmount);
        em.persist(user);

        Chatroom chatroom = new Chatroom();
        chatroom.setChatroomName("친구들모임");
        em.persist(chatroom);

        UserChatroom userChatroom = new UserChatroom();
        em.persist(userChatroom);

        // when
        int userCount = 5;
        long sprinkleAmount = 1000;
        userChatroomService.requestSprinkleMoney(
                user.getUserId(),
                chatroom.getChatroomId(),
                userChatroom.getUserChatroomId(),
                userCount,
                sprinkleAmount
        );

        // then
        System.out.println(userChatroom.getMessages().get(0));
        Assertions.assertThat(user.getMoneyAmount()).isEqualTo(initAmount-sprinkleAmount);
    }
}