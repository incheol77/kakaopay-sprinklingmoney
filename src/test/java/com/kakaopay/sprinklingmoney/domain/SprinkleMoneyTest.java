package com.kakaopay.sprinklingmoney.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SprinkleMoneyTest {

    @Test
    public void testCreateSprinkleMoney() throws Exception {
        // given
        int userCount = 10;
        int moneyAmount = 2000;
        SprinkleMoney sprinkleMoney = SprinkleMoney.createSprinkleMoney(new UserChatroom(), userCount, moneyAmount);

        // when
        int resultUserCount = sprinkleMoney.getSprinkleUserCount();
        long resultMoneyAmount = sprinkleMoney.getSprinkleMoneyAmount();

        // then
        Assertions.assertThat(resultUserCount).isEqualTo(userCount);
        Assertions.assertThat(resultMoneyAmount).isEqualTo(moneyAmount);
    }
}