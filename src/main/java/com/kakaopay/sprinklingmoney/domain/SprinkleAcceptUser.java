package com.kakaopay.sprinklingmoney.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
