package com.kakaopay.sprinklingmoney.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Chatroom {

    @Id
    @Column(name = "chatroom_id")
    private String chatroomId;

    private String chatroomName;

    private int userCount;

    @OneToMany(mappedBy = "chatroom")
    private List<UserChatroom> userChatrooms = new ArrayList<>();
}
