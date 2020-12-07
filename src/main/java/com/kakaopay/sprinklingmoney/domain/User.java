package com.kakaopay.sprinklingmoney.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    private String loginId;
    private String password;
    private String userNickname;
    private Long moneyAmount;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserChatroom> userChatrooms = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<SprinkleAcceptUser> sprinkleAcceptUsers = new ArrayList<>();

    //===== 연관 관계 편의 메소드 =====//
    public void addUserChatroom(UserChatroom userChatroom) {
        userChatrooms.add(userChatroom);
        userChatroom.setUser(this);
    }

    public void addSprinkleAcceptUser(SprinkleAcceptUser sprinkleAcceptUser) {
        sprinkleAcceptUsers.add(sprinkleAcceptUser);
        sprinkleAcceptUser.setUser(this);
    }
}
