package com.kakaopay.sprinklingmoney.service;

import com.kakaopay.sprinklingmoney.domain.SprinkleMoney;
import com.kakaopay.sprinklingmoney.domain.UserChatroom;
import com.kakaopay.sprinklingmoney.repository.SprinkleMoneyRepository;
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
public class SprinkleMoneyServiceTest {

    @Autowired SprinkleMoneyService sprinkleMoneyService;
    @Autowired SprinkleMoneyRepository sprinkleMoneyRepository;

    @Test
    public void testAddSprinkle() throws Exception {
        // given
        SprinkleMoney sprinkleMoney =
                SprinkleMoney.createSprinkleMoney(new UserChatroom(), 5, 1000);

        // when
        Long sprinkleMoneyId = sprinkleMoneyService.addSprinkle(sprinkleMoney);

        // then
        Assertions.assertThat(sprinkleMoney).isEqualTo(sprinkleMoneyRepository.findOne(sprinkleMoneyId));
    }

}