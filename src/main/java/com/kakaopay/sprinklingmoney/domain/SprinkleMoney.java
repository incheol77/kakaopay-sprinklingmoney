package com.kakaopay.sprinklingmoney.domain;

import com.kakaopay.sprinklingmoney.repository.UserChatroomRepository;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class SprinkleMoney {

    @Id @GeneratedValue
    @Column(name = "sprinkle_id")
    private Long sprinkleId;

    @ManyToOne
    @JoinColumn(name = "user_chatroom_id")
    private UserChatroom userChatroom;

    private LocalDateTime sendDateTime;

    private int sprinkleUserCount;

    private int sprinkleMoneyAmount;

    @Enumerated(EnumType.STRING)
    private SprinkleStatus sprinkleStatus;

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
