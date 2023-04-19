package com.sjh.peanutfriends_0324.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member masterMember;
    private String startDate;
    private String endDate;

    @OneToMany(mappedBy = "basket")
    @JsonIgnore
    private List<BasketMember> myMember = new ArrayList<>();

}
