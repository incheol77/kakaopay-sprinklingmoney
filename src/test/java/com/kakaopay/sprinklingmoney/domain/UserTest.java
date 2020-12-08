package com.kakaopay.sprinklingmoney.domain;

import com.kakaopay.sprinklingmoney.exception.NotEnoughMoneyAmountException;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Test
    public void testGetSetUserId() throws Exception {
        // given
        User user = new User();
        Long testUserId = 12345678L;

        // when
        user.setUserId(testUserId);

        // then
        Assertions.assertThat(testUserId).isEqualTo(user.getUserId());
    }

    @Test
    public void testGetSetLoginId() throws Exception {
        // given
        User user = new User();
        String testLoginId = "abc@emalil.com";

        // when
        user.setLoginId(testLoginId);

        // then
        Assertions.assertThat(testLoginId).isEqualTo(user.getLoginId());
    }

    @Test
    public void testGetSetUserNickname() throws Exception {
        // given
        User user = new User();
        String testUserNickname = "건강한 세상, 모두들 힘내세요!";

        // when
        user.setUserNickname(testUserNickname);

        // then
        Assertions.assertThat(testUserNickname).isEqualTo(user.getUserNickname());
    }

    @Test
    public void testGetSetMoneyAmount() throws Exception {
        // given
        User user = new User();
        Long testMoneyAmount = 123456789L;

        // when
        user.setMoneyAmount(testMoneyAmount);

        // then
        Assertions.assertThat(testMoneyAmount).isEqualTo(user.getMoneyAmount());
    }

    @Test
    public void testGetSetUserChatroom() throws Exception {
        // given
        User user = new User();
        List<UserChatroom>  userChatrooms = new ArrayList<>();

        // when
        user.setUserChatrooms(userChatrooms);

        // then
        Assertions.assertThat(userChatrooms).isEqualTo(user.getUserChatrooms());
    }

    @Test
    public void testAddMoneyAmount() throws Exception {
        // given
        User user = new User();
        Long initAmount= 1000L;
        user.setMoneyAmount(initAmount);

        // when
        Long addAmount = 500L;
        Assertions.assertThat(initAmount).isEqualTo(user.getMoneyAmount());
        user.addMoneyAmount(addAmount);

        // then
        Assertions.assertThat(initAmount + addAmount).isEqualTo(user.getMoneyAmount());
    }

    @Test
    public void testSubtractMoneyAmount() throws Exception {
        // given
        User user = new User();
        Long initAmount= 1000L;
        user.setMoneyAmount(initAmount);

        // when
        Long subtractAmount = 500L;
        Assertions.assertThat(initAmount).isEqualTo(user.getMoneyAmount());
        user.subtractMoneyAmount(subtractAmount);

        // then
        Assertions.assertThat(initAmount - subtractAmount).isEqualTo(user.getMoneyAmount());
    }

    @Test(expected = NotEnoughMoneyAmountException.class)
    public void testNotEnoughMoneyAmountException() throws Exception {
        // given
        User user = new User();
        Long initAmount= 1000L;
        user.setMoneyAmount(initAmount);

        // when
        Long subtractAmount = 2000L;
        Assertions.assertThat(initAmount).isEqualTo(user.getMoneyAmount());
        user.subtractMoneyAmount(subtractAmount);   // 예외 발생해야 함.

        // then
        fail("예외가 발생해야 한다.");
    }
}