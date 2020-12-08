package com.kakaopay.sprinklingmoney.repository;

import com.kakaopay.sprinklingmoney.domain.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MessageRepository {

    private final EntityManager em;

    public void save(Message message) {
        if (message.getMessageId() == null) {
            em.persist(message);
        } else {
            em.merge(message);
        }
    }

    public Message findOne(Long id) {
        return em.find(Message.class, id);
    }

    public List<Message> findAll() {
        return em.createQuery("select m from Message m", Message.class)
                .getResultList();
    }
}
