package com.kakaopay.sprinklingmoney.service;


import com.kakaopay.sprinklingmoney.domain.SprinkleAcceptUser;
import com.kakaopay.sprinklingmoney.repository.SprinkleAcceptUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SprinkleAcceptUserService {

    private final SprinkleAcceptUserRepository sprinkleAcceptUserRepository;

    public Long addSprinkleAcceptUser(SprinkleAcceptUser sprinkleAcceptUser) {
        sprinkleAcceptUserRepository.save(sprinkleAcceptUser);
        return sprinkleAcceptUser.getAcceptUserNo();
    }
}
