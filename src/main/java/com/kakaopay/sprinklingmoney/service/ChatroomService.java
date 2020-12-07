package com.kakaopay.sprinklingmoney.service;

import com.kakaopay.sprinklingmoney.domain.Chatroom;
import com.kakaopay.sprinklingmoney.repository.ChatroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ChatroomService {

    private final ChatroomRepository chatroomRepository;

    /**
     * 대화방 등록
     */
    @Transactional
    public String register(Chatroom chatroom) {
       chatroomRepository.save(chatroom);
       return chatroom.getChatroomId();
    }

    /**
     * 대화방 전체 조회
     */
    public List<Chatroom> findAllChatrooms() {
        return chatroomRepository.findAll();
    }

    /**
     * 개별 대화방 조회 (with 대화방이름)
     */
    public List<Chatroom> findByChatroomName(String chatroomName) {
        return chatroomRepository.findByChatroomName(chatroomName);
    }
}
