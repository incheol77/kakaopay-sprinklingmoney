package com.kakaopay.sprinklingmoney.repository;

import com.kakaopay.sprinklingmoney.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

    public List<User> findByLoginId(String loginId) {
        return em.createQuery("select u from User u where u.loginId = :loginId", User.class)
                .setParameter("loginId", loginId)
                .getResultList();
    }

    /**
     * TODO : If this is necessary, implement these methods.
    public List<User> findByUserNickname(String nickname) {

    }
    */
}
