package com.kakaopay.sprinklingmoney.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserChatroomTest {
    @Test
    public void testGetterSetterUser() throws Exception {
        // given
        UserChatroom userChatroom = new UserChatroom();
        User testUser = new User();
        Long testUserId = 12345678L;

        // when
        userChatroom.setUser(testUser);
        testUser.setUserId(testUserId);

        // then
        Assertions.assertThat(testUser).isEqualTo(userChatroom.getUser());
        Assertions.assertThat(testUserId).isEqualTo(userChatroom.getUser().getUserId());
    }

    @Test
    public void testGetterSetterChatroom() throws Exception {
        // given
        UserChatroom userChatroom = new UserChatroom();
        Chatroom testChatroom = new Chatroom();
        String testChatroomId = "chatroom-id-123";

        // when
        userChatroom.setChatroom(testChatroom);
        testChatroom.setChatroomId(testChatroomId);

        // then
        Assertions.assertThat(testChatroom).isEqualTo(userChatroom.getChatroom());
        Assertions.assertThat(testChatroomId).isEqualTo(userChatroom.getChatroom().getChatroomId());
    }

    @Test
    public void testGetterSetterUserRole() throws Exception {
        // given
        UserChatroom userChatroom = new UserChatroom();
        UserRole owner = UserRole.OWNER;
        UserRole guest = UserRole.PARTICIPANT;
        String testChatroomId = "chatroom-id-123";
        Long testUserId = 12345678L;

        // when & then
        userChatroom.setUserRole(owner);
        Assertions.assertThat(UserRole.OWNER).isEqualTo(userChatroom.getUserRole());

        userChatroom.setUserRole(guest);
        Assertions.assertThat(UserRole.PARTICIPANT).isEqualTo(userChatroom.getUserRole());
    }
}