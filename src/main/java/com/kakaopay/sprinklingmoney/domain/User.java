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
}
