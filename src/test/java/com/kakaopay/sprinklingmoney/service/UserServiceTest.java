package com.kakaopay.sprinklingmoney.service;

import com.kakaopay.sprinklingmoney.domain.User;
import com.kakaopay.sprinklingmoney.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.fail;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;

    /**
     * 사용자 등록 테스트
     */
    @Test
    public void testJoinUser() throws Exception {
        // given
        User user = new User();
        user.setLoginId("testloginid@email.com");

        // when
        Long newUserId = userService.join(user);

        // then
        Assertions.assertThat(user).isEqualTo(userRepository.findOne(newUserId));
    }

    /**
     * 중복 사용자 등록 예외 발생 테스트
     */
    @Test(expected = IllegalStateException.class)
    public void testDuplicatedUserException() throws Exception {
        // given
        User user1 = new User();
        user1.setLoginId("testloginid@email.com");

        User user2 = new User();
        user2.setLoginId("testloginid@email.com");

        // when
        userService.join(user1);
        userService.join(user2);    // 예외 발생해야 함.

        // then
        fail("예외가 발생해야 한다.");
    }

}