package com.kakaopay.sprinklingmoney.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Chatroom {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "chatroom_id")
    private String chatroomId;

    /**
     *
     * - 대화방(chatroom)의 식별자가 문자 형태로 주어졌으나 대화방 식별자와 대화방 이름을 분리한 이유 :
     *
     * 식별자인 chatroomID 가 String 타입이지만 '대화방명'을 식별자로 사용할 경우
     * 한번 설정한 '대화방 제목'을 변경하기 어려우므로 (식별자 변경...거대한 고통의 시작...ㅠㅠ)
     * 별도의 '대화방명(chatroomName)' 을 두어 자유롭게 대화방명을 변경할 수 있게 한다.
     * - 본 과제의 요건에 포함되어 있지는 않으나 매우 일반적인 대화방의 기능이므로 추가함
     *
     *  written by ickim 2020.12.07
     */
    private String chatroomName;

    private int userCount;

    @OneToMany(mappedBy = "chatroom", cascade = CascadeType.ALL)
    private List<UserChatroom> userChatrooms = new ArrayList<>();
}
