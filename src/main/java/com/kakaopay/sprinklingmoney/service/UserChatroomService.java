package com.kakaopay.sprinklingmoney.service;

import com.kakaopay.sprinklingmoney.domain.Chatroom;
import com.kakaopay.sprinklingmoney.domain.User;
import com.kakaopay.sprinklingmoney.domain.UserChatroom;
import com.kakaopay.sprinklingmoney.repository.UserChatroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserChatroomService {

    private final UserChatroomRepository userChatroomRepository;

    @Transactional
    public Long addUserToChatroom(User user, Chatroom chatroom) {
        // TODO : 중복 사용자-대화방 체크 (with userNickname, chatroomName)
        // validateDuplicateUserChatroomPair(user, chatroom);
        UserChatroom userChatroom = new UserChatroom(user, chatroom);
        userChatroomRepository.save(userChatroom);
        return userChatroom.getUserChatroomId();
    }

    /* TODO : If this is necessary, implement these methods.
    private void validateDuplicateUserChatroomPair(User user, Chatroom chatroom) {
        List<UserChatroom> findUserChatroomPair =
                userChatroomRepository.findByUserIdChatroomId(user.getUserId(), chatroom.getChatroomId());
        if (!findUserChatroomPair.isEmpty()) {
            throw new IllegalStateException("이미 대화방에 등록된 사용자입니다");
        }
    }
     */
}
