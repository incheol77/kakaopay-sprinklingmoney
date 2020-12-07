package com.kakaopay.sprinklingmoney.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collections;

@Entity
@Getter @Setter
public class SprinkleAcceptUser {

    @Id @GeneratedValue
    @Column(name = "accept_user_no")
    private Long acceptUserNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sprinkle_id")
    private SprinkleMoney sprinkleMoney;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private int acceptMoneyAmount;

    //===== 연관 관계 편의 메소드 =====//
    public void setUser(User user) {
        this.user = user;
        user.getSprinkleAcceptUsers().add(this);
    }

    public void setSprinkleMoney(SprinkleMoney sprinkleMoney) {
        this.sprinkleMoney = sprinkleMoney;
        sprinkleMoney.getSprinkleAcceptUsers().add(this);
    }

    // ===== create method ===== //
    public static SprinkleAcceptUser createSprinkleAcceptUser(SprinkleMoney sprinkleMoney,
                                                       User user,
                                                       int acceptMoneyAmount) {

        SprinkleAcceptUser sprinkleAcceptUser = new SprinkleAcceptUser();

        sprinkleAcceptUser.setSprinkleMoney(sprinkleMoney);
        sprinkleAcceptUser.setUser(user);
        sprinkleAcceptUser.setAcceptMoneyAmount(acceptMoneyAmount);

        return sprinkleAcceptUser;
    }
}
