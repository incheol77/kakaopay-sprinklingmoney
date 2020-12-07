package com.kakaopay.sprinklingmoney.service;

import com.kakaopay.sprinklingmoney.domain.SprinkleMoney;
import com.kakaopay.sprinklingmoney.repository.SprinkleMoneyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SprinkleMoneyService {

    private final SprinkleMoneyRepository sprinkleMoneyRepository;

    public Long addSprinkle(SprinkleMoney sprinkleMoney) {
        sprinkleMoneyRepository.save(sprinkleMoney);
        return sprinkleMoney.getSprinkleId();
    }
}
