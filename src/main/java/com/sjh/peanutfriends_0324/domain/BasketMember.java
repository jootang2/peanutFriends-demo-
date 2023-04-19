package com.sjh.peanutfriends_0324.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BasketMember {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "BASKET_ID")
    private Basket basket;


}
