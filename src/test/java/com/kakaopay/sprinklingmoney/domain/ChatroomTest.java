package com.kakaopay.sprinklingmoney.domain;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatroomTest {

    @Test
    public void testGetSetChatroomId() throws Exception {
        // given
        Chatroom chatroom = new Chatroom();
        String testChatroomId = "chatroom-id-123";

        // when
        chatroom.setChatroomId(testChatroomId);

        // then
        Assertions.assertThat(testChatroomId).isEqualTo(chatroom.getChatroomId());
    }

    @Test
    public void testGetSetChatRoomName() throws Exception {
        // given
        Chatroom chatroom = new Chatroom();
        String testChatroomName = "참즐거운대화방";

        // when
        chatroom.setChatroomName(testChatroomName);

        // then
        Assertions.assertThat(testChatroomName).isEqualTo(chatroom.getChatroomName());
    }

    @Test
    public void testGetSetUserCount() throws Exception {
        // given
        Chatroom chatroom = new Chatroom();
        int testUserCount = 100;

        // when
        chatroom.setUserCount(testUserCount);

        // then
        Assertions.assertThat(testUserCount).isEqualTo(chatroom.getUserCount());
    }

    @Test
    public void testGetSetUserChatrooms() throws Exception {
        // given
        Chatroom chatroom = new Chatroom();
        List<UserChatroom> testUserChatrooms = new ArrayList<>();

        // when
        chatroom.setUserChatrooms(testUserChatrooms);

        // then
        Assertions.assertThat(testUserChatrooms).isEqualTo(chatroom.getUserChatrooms());
    }







}