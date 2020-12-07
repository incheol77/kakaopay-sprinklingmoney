package com.kakaopay.sprinklingmoney.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Chatroom {

    @Id
    @Column(name = "chatroom_id")
    private String chatroomId;

    // 식별자인 chatroomID 가 String 타입이지만 '대화방명'을 식별자로 사용할 경우
    // 한번 설정한 '대화방 제목'을 변경하기 어려우므로 (식별자 변경...거대한 고통의 시작...ㅠㅠ)
    // 별도의 '대화방명(chatroomName)' 을 두어 자유롭게 대화방명을 변경할 수 있게 한다.
    // - 본 과제의 요건에 포함되어 있지는 않으나 매우 일반적인 대화방의 기능이므로 추가함
    // written by ickim 2020.12.07
    private String chatroomName;

    private int userCount;

    @OneToMany(mappedBy = "chatroom")
    private List<UserChatroom> userChatrooms = new ArrayList<>();
}
