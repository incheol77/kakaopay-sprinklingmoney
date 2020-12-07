package com.kakaopay.sprinklingmoney.repository;

import com.kakaopay.sprinklingmoney.domain.SprinkleMoney;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SprinkleMoneyRepository {

    private final EntityManager em;

    public void save(SprinkleMoney sprinkleMoney) {
        em.persist(sprinkleMoney);
    }

    public SprinkleMoney findOne(Long id) {
        return em.find(SprinkleMoney.class, id);
    }

    public List<SprinkleMoney> findAll() {
        return em.createQuery("select s from SprinkleMoney s", SprinkleMoney.class)
                .getResultList();
    }
}
