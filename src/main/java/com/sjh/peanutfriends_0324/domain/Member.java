package com.sjh.peanutfriends_0324.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 255)
    private String email;

    @Column(length = 50)
    private String name;

    @Column(length = 500)
    private String password;

    @CreationTimestamp
    private LocalDateTime regdate;

    @OneToMany(mappedBy = "member")
    private List<MemberBasket> memberBasket = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "member_role",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
        roles.add(role);
    }

    public Member() {

    }

    public Member(Long memberId, String email, String name, String password, LocalDateTime regdate, List<MemberBasket> memberBasket, Set<Role> roles) {
        this.memberId = memberId;
        this.email = email;
        this.name = name;
        this.password = password;
        this.regdate = regdate;
        this.memberBasket = memberBasket;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "memberId=" + memberId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", regdate=" + regdate +
                '}';
    }
}
