package com.sjh.peanutfriends_0324.service;

import com.sjh.peanutfriends_0324.domain.BasketMember;
import com.sjh.peanutfriends_0324.repository.BasketMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketMemberService {
    private final BasketMemberRepository basketMemberRepository;

    public void add(BasketMember basketMember) {
        basketMemberRepository.save(basketMember);
    }
}
