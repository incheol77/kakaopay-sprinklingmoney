package com.kakaopay.sprinklingmoney.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_chatroom")
@Getter @Setter
public class UserChatroom {

    @Id @GeneratedValue
    private Long userChatroomId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chatroom_id")
    private Chatroom chatroom;

    @OneToMany(mappedBy = "userChatroom", cascade = CascadeType.ALL)
    private List<Message> messages = new ArrayList<>();

    @OneToMany(mappedBy = "userChatroom", cascade = CascadeType.ALL)
    private List<SprinkleMoney> sprinkles = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private UserRole userRole;  // 대화방 참여자 역할 [OWNER, PARTICIPANT]


    // ===== Constructors ===== //
    public UserChatroom() {}

    public UserChatroom(User user, Chatroom chatroom) {
        this.user = user;
        this.chatroom = chatroom;
    }
}
