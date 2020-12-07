package com.kakaopay.sprinklingmoney.repository;

import com.kakaopay.sprinklingmoney.domain.Chatroom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ChatroomRepository {

    private final EntityManager em;

    public void save(Chatroom chatroom) {
        em.persist(chatroom);
    }

    public Chatroom findOne(String id) {
        return em.find(Chatroom.class, id);
    }

    public List<Chatroom> findAll() {
        return em.createQuery("select c from Chatroom c", Chatroom.class)
                .getResultList();
    }

    public List<Chatroom> findByChatroomName(String chatroomName) {
        return em.createQuery("select c from Chatroom c where c.chatroomName = :chatroomName", Chatroom.class)
                .setParameter("chatroomName", chatroomName)
                .getResultList();
    }
}
