package com.kakaopay.sprinklingmoney.service;

import com.kakaopay.sprinklingmoney.domain.User;
import com.kakaopay.sprinklingmoney.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * 사용자 등록
     */
    @Transactional
    public Long join(User user) {
        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getUserId();
    }

    // TODO (MLTH) : multithread concurrency 상황을 고려하여 DB user.login_id unique index 추가
    private void validateDuplicateUser(User user) {
        List<User> findUsers = userRepository.findByLoginId(user.getLoginId());
        if (!findUsers.isEmpty()) {
            throw new IllegalStateException("이미 등록된 사용자입니다");
        }
    }

    /**
     * 사용자 전체 조회
     */
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    /**
     * 개별 사용자 조회
     */
    public User findOneUser(Long userId) {
        return userRepository.findOne(userId);
    }
}
