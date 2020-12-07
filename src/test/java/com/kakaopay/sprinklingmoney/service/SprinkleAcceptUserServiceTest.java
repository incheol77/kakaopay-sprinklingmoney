package com.kakaopay.sprinklingmoney.service;

import com.kakaopay.sprinklingmoney.domain.SprinkleAcceptUser;
import com.kakaopay.sprinklingmoney.domain.SprinkleMoney;
import com.kakaopay.sprinklingmoney.domain.User;
import com.kakaopay.sprinklingmoney.repository.SprinkleAcceptUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SprinkleAcceptUserServiceTest {

    @Autowired SprinkleAcceptUserService sprinkleAcceptUserService;
    @Autowired SprinkleAcceptUserRepository sprinkleAcceptUserRepository;

    @Test
    public void testAddSprinkleAcceptUser() throws Exception {
        // given
        SprinkleAcceptUser sprinkleAcceptUser =
                SprinkleAcceptUser.createSprinkleAcceptUser(new SprinkleMoney(), new User(), 100);

        // when
        Long sprinkleAcceptUserNo = sprinkleAcceptUserService.addSprinkleAcceptUser(sprinkleAcceptUser);

        // then
        Assertions.assertThat(sprinkleAcceptUser).isEqualTo(sprinkleAcceptUserRepository.findOne(sprinkleAcceptUserNo));
    }
}