package com.kakaopay.sprinklingmoney.repository;

import com.kakaopay.sprinklingmoney.domain.SprinkleAcceptUser;
import com.kakaopay.sprinklingmoney.domain.SprinkleMoney;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SprinkleAcceptUserRepository {

    private final EntityManager em;

    public void save(SprinkleAcceptUser sprinkleAcceptUser) {
        em.persist(sprinkleAcceptUser);
    }

    public SprinkleAcceptUser findOne(Long id) {
        return em.find(SprinkleAcceptUser.class, id);
    }

    public List<SprinkleAcceptUser> findAll() {
        return em.createQuery("select s from SprinkleAcceptUser s", SprinkleAcceptUser.class)
                .getResultList();
    }
}
