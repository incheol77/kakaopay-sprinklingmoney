package com.kakaopay.sprinklingmoney.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class SprinkleMoney {

    @Id @GeneratedValue
    @Column(name = "sprinkle_id")
    private Long sprinkleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_chatroom_id")
    private UserChatroom userChatroom;

    @OneToMany(mappedBy = "sprinkleMoney", cascade = CascadeType.ALL)
    private List<SprinkleAcceptUser> sprinkleAcceptUsers = new ArrayList<>();

    private LocalDateTime sendDateTime;

    private int sprinkleUserCount;

    private int sprinkleMoneyAmount;

    @Enumerated(EnumType.STRING)
    private SprinkleStatus sprinkleStatus;

    //===== 연관 관계 편의 메소드 =====//
    public void setUserChatroom(UserChatroom userChatroom) {
        this.userChatroom = userChatroom;
        userChatroom.getSprinkleMoneys().add(this);
    }
    public void addSprinkleAcceptUser(SprinkleAcceptUser sprinkleAcceptUser) {
        sprinkleAcceptUsers.add(sprinkleAcceptUser);
        sprinkleAcceptUser.setSprinkleMoney(this);
    }


    // ===== create method ===== //
    public static SprinkleMoney createSprinkleMoney(UserChatroom userChatroom,
                                                    int sprinkleUserCount,
                                                    int sprinkleMoneyAmount) {

        SprinkleMoney sprinkleMoney = new SprinkleMoney();

        sprinkleMoney.setUserChatroom(userChatroom);
        sprinkleMoney.setSprinkleUserCount(sprinkleUserCount);
        sprinkleMoney.setSprinkleMoneyAmount(sprinkleMoneyAmount);
        sprinkleMoney.setSprinkleStatus(SprinkleStatus.OPEN);
        sprinkleMoney.setSendDateTime(LocalDateTime.now());

        return sprinkleMoney;
    }
}
