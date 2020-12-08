package com.kakaopay.sprinklingmoney.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageTest {

    @Test
    public void testCreateMessage() throws Exception {
        // given
        String testContents = "테스트 메시지입니다. 건강한 하루되시길...";
        Message newMessage = Message.createMessage(new UserChatroom(), testContents);

        // when
        String resultContents = testContents;

        // then
        Assertions.assertThat(resultContents).isEqualTo(testContents);
    }

}