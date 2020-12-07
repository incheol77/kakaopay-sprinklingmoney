package com.kakaopay.sprinklingmoney.repository;

import com.kakaopay.sprinklingmoney.domain.UserChatroom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserChatroomRepository {

    private final EntityManager em;

    public void save(UserChatroom userChatroom) {
        em.persist(userChatroom);
    }

    public UserChatroom findOne(Long id) {
        return em.find(UserChatroom.class, id);
    }

    public List<UserChatroom> findAll() {
        return em.createQuery("select uc from UserChatroom uc", UserChatroom.class)
                .getResultList();
    }

    public List<UserChatroom> findByUserIdChatroomId(Long userId, String chatroomId) {
        return em.createQuery("select uc from userChatroom uc where uc.userId = :userId and uc.chatroomId = :chatroomId", UserChatroom.class)
                .setParameter("userId", userId)
                .setParameter("chatroomId", chatroomId)
                .getResultList();
    }

    /* TODO : If this is necessary, implement these methods.
    public List<UserChatroom> findByUserNickname(String userNickname) {

    }

    public List<UserChatroom> findByChatroomName(String chatroomName) {

    }
    */
}
