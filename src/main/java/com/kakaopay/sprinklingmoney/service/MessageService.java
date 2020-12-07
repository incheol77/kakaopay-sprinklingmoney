package com.kakaopay.sprinklingmoney.service;

import com.kakaopay.sprinklingmoney.domain.Message;
import com.kakaopay.sprinklingmoney.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public Long addMessage(Message message) {
        messageRepository.save(message);
        return message.getMessageId();
    }
}
