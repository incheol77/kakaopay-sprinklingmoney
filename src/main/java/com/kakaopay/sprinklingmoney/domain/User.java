package com.kakaopay.sprinklingmoney.domain;

import com.kakaopay.sprinklingmoney.exception.NotEnoughMoneyAmountException;
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

    //===== Biz Logic =====//

    /**
     * 머니 잔액 증가
     *
     * @param amount
     */
    public void addMoneyAmount(Long amount) {
        this.moneyAmount += amount;
    }

    /**
     * 머니 잔액 감소
     *
     * @param amount
     * @throws Exception
     */
    public void subtractMoneyAmount(Long amount) throws Exception {
        Long restMoney = this.moneyAmount - amount;
        if (restMoney < 0) {
            throw new NotEnoughMoneyAmountException("빼려는 금액이 잔액보다 큽니다");
        }
        this.moneyAmount = restMoney;
    }
}
