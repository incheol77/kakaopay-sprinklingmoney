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
    private List<SprinkleMoney> sprinkleMoneys = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private UserRole userRole;  // 대화방 참여자 역할 [OWNER, PARTICIPANT]

    //===== 연관 관계 편의 메소드 =====//
    public void setUser(User user) {
        this.user = user;
        user.getUserChatrooms().add(this);
    }

    public void setChatroom(Chatroom chatroom) {
        this.chatroom = chatroom;
        chatroom.getUserChatrooms().add(this);
    }

    public void addSprinkleMoney(SprinkleMoney sprinkleMoney) {
        sprinkleMoneys.add(sprinkleMoney);
        sprinkleMoney.setUserChatroom(this);
    }

    public void addMessages(Message message) {
        messages.add(message);
        message.setUserChatroom(this);
    }


    // ===== Constructors ===== //
    public UserChatroom() {}

    public UserChatroom(User user, Chatroom chatroom) {
        this.user = user;
        this.chatroom = chatroom;
    }


    // ===== Biz Logic ===== //

    // ===== For SprinkleMoney ===== //
    public SprinkleMoney createSprinkleMoney(int sprinkleUserCount, long sprinkleMoneyAmount) {
        SprinkleMoney newSprinkleMoney =
                SprinkleMoney.createSprinkleMoney(this, sprinkleUserCount, sprinkleMoneyAmount);
        addSprinkleMoney(newSprinkleMoney);
        return newSprinkleMoney;
    }

    public void removeSprinkleMoney(SprinkleMoney sprinkleMoney) {
        SprinkleMoney deleteSprinkleMoney = findSprinkleMoney(sprinkleMoney);
        deleteSprinkleMoney(deleteSprinkleMoney);
    }

    public SprinkleMoney findSprinkleMoney(SprinkleMoney targetSprinkleMoney) {
        for  (SprinkleMoney sprinkleMoney : sprinkleMoneys) {
            if (isEqualSprinkleMoney(targetSprinkleMoney, sprinkleMoney)) {
                return sprinkleMoney;
            }
        }
        return null;
    }

    private boolean isEqualSprinkleMoney(SprinkleMoney sprinkleMoney1, SprinkleMoney sprinkleMoney2) {
        return (sprinkleMoney1 != null && sprinkleMoney2 != null) && sprinkleMoney1.equals(sprinkleMoney2);
    }

    private void deleteSprinkleMoney(SprinkleMoney deleteSprinkleMoney) {
        if (deleteSprinkleMoney == null) {
           return;
        }
        sprinkleMoneys.remove(deleteSprinkleMoney);
    }

    // ===== For Message ===== //
    public Message createMessage(String contents) {
        Message newMessage = Message.createMessage(this, contents);
        addMessages(newMessage);
        return newMessage;
    }

    public void removeMessage(Message message) {
        Message deleteMessage = findMessage(message);
        deleteMessage(deleteMessage);
    }

    private Message findMessage(Message targetMessage) {
        for  (Message message : messages) {
            if (isEqualMessage(targetMessage, message != null, message)) {
                return message;
            }
        }
        return null;
    }

    private boolean isEqualMessage(Message message1, boolean b, Message message2) {
        return (message1 != null && b) && message1.equals(message2);
    }

    private void deleteMessage(Message deleteMessage) {
        if (deleteMessage == null) {
            return;
        }
        messages.remove(deleteMessage);
    }
}
