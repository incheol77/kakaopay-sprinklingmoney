package com.kakaopay.sprinklingmoney.service;

import com.kakaopay.sprinklingmoney.domain.Message;
import com.kakaopay.sprinklingmoney.repository.MessageRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MessageServiceTest {

    @Autowired MessageService messageService;
    @Autowired MessageRepository messageRepository;

    @Test
    public void testAddMessage() throws Exception {
        // given
        Message message = new Message();
        message.setContents("test message : Hello world!");

        // when
        Long messageId = messageService.addMessage(message);

        // then
        Assertions.assertThat(message).isEqualTo(messageRepository.findOne(messageId));
    }

}