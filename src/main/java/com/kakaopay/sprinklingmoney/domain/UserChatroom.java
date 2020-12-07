package com.kakaopay.sprinklingmoney.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_chatroom")
@Getter @Setter
class UserChatroom {

    @Id @GeneratedValue
    private Long userChatroomId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "chatroom_id")
    private Chatroom chatroom;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;  // 대화방 참여자 역할 [OWNER, PARTICIPANT]
}
