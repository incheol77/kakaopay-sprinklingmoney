package com.kakaopay.sprinklingmoney.service;

import com.kakaopay.sprinklingmoney.domain.*;
import com.kakaopay.sprinklingmoney.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserChatroomService {

    private final UserChatroomRepository userChatroomRepository;
    private final UserRepository userRepository;
    private final ChatroomRepository chatroomRepository;
    private final SprinkleMoneyRepository sprinkleMoneyRepository;
    private final MessageRepository messageRepository;

    int randomSize = 3;

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

    /**
     *
     * @param userId
     * @param chatroomId
     * @param userChatroomId
     * @param userCount
     * @param moneyAmount
     * @return token 으로 사용될 3자리 random 문자열 (영문대문자/영문소문자/숫자 조합)
     * @throws Exception
     */
    @Transactional
    public String requestSprinkleMoney(Long userId,
                                     String chatroomId,
                                     Long userChatroomId,
                                     int userCount,
                                     long moneyAmount) throws Exception {

        // 1. 뿌리기에 관련된 객체들 초기화
        User user = userRepository.findOne(userId);
        UserChatroom userChatroom = userChatroomRepository.findOne(userChatroomId);
        Chatroom chatroom = chatroomRepository.findOne(chatroomId);

        // 2. 뿌린 사용자의 잔액에서 뿌린 금액만큼 차감
        user.subtractMoneyAmount(moneyAmount);

        // 3. 뿌리기 객체와 뿌리기 결과 메시지 생성
        SprinkleMoney sprinkleMoney = userChatroom.createSprinkleMoney(userCount, moneyAmount);
        Message sprinkleMessage = userChatroom.createMessage(
                makeMessageContents(userCount, moneyAmount, user.getUserNickname(), chatroom.getChatroomName())
        );

        // 4. 뿌리기 결과가 반영된 객체 저장
        userRepository.save(user);
        sprinkleMoneyRepository.save(sprinkleMoney);
        messageRepository.save(sprinkleMessage);

        return RandomGenerator.makeRandomString(randomSize);
    }

    private String makeMessageContents(int sprinkleUserCount,
                                       long sprinkleMoneyAmount,
                                       String userNickname,
                                       String chatroomName) {

        return "[" + userNickname + "] 님이 " + "대화방 [" + chatroomName + "] 의 ["
                + sprinkleUserCount + "] 명의 회원님들께 [" + sprinkleMoneyAmount + "] 원을 뿌리셨습니다";
    }
}
