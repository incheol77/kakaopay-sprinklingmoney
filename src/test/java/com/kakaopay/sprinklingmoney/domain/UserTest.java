package com.kakaopay.sprinklingmoney.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Test
    public void getSetUserIdTest() throws Exception {
        // given
        User user = new User();
        Long testUserId = 12345678L;

        // when
        user.setUserId(testUserId);

        // then
        Assertions.assertThat(testUserId).isEqualTo(user.getUserId());
    }

    @Test
    public void getSetLoginIdTest() throws Exception {
        // given
        User user = new User();
        String testLoginId = "abc@emalil.com";

        // when
        user.setLoginId(testLoginId);

        // then
        Assertions.assertThat(testLoginId).isEqualTo(user.getLoginId());
    }

    @Test
    public void getSetUserNickname() throws Exception {
        // given
        User user = new User();
        String testUserNickname = "건강한 세상, 모두들 힘내세요!";

        // when
        user.setUserNickname(testUserNickname);

        // then
        Assertions.assertThat(testUserNickname).isEqualTo(user.getUserNickname());
    }

    @Test
    public void getSetMoneyAmount() throws Exception {
        // given
        User user = new User();
        Long testMoneyAmount = 123456789L;

        // when
        user.setMoneyAmount(testMoneyAmount);

        // then
        Assertions.assertThat(testMoneyAmount).isEqualTo(user.getMoneyAmount());
    }
}