package com.kakaopay.sprinklingmoney.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Message {

    @Id @GeneratedValue
    private Long messageId;

    @ManyToOne
    @JoinColumn(name = "user_chatroom_id")
    private UserChatroom userChatroom;

    private LocalDateTime sendDateTime;
    private String contents;

    /*
     * TODO : If this is necessary, implement these methods.
    public void setUserIdFromUserChatroom() {
        if (this.getUserChatroom() != null) {
            this.setUserId(this.getUserChatroom().getUser().getUserId());
        }
    }

    public void setChatroomIdFromUserChatroom() {
        if (this.getUserChatroom() != null) {
            this.setChatroomId(this.getUserChatroom().getChatroom().getChatroomId());
        }
    }
    */
}
