package com.sjh.peanutfriends_0324.domain;

import jakarta.persistence.*;

@Entity
public class MemberBasket {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "BASKET_ID")
    private Basket basket;


}
