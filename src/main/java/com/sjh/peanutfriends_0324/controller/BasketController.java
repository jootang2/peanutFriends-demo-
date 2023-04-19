package com.sjh.peanutfriends_0324.controller;

import com.sjh.peanutfriends_0324.domain.Basket;
import com.sjh.peanutfriends_0324.domain.BasketMember;
import com.sjh.peanutfriends_0324.domain.Member;
import com.sjh.peanutfriends_0324.domain.Role;
import com.sjh.peanutfriends_0324.dto.AddBasketDto;
import com.sjh.peanutfriends_0324.security.jwt.util.IfLogin;
import com.sjh.peanutfriends_0324.security.jwt.util.LoginUserDto;
import com.sjh.peanutfriends_0324.service.BasketMemberService;
import com.sjh.peanutfriends_0324.service.BasketService;
import com.sjh.peanutfriends_0324.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BasketController {

    private final BasketService basketService;
    private final MemberService memberService;
    private final BasketMemberService basketMemberService;

    @PostMapping("/basket/create")
    public Basket addBasket(@IfLogin LoginUserDto loginUserDto, @RequestBody AddBasketDto addBasketDto) {
        Basket basket = new Basket();
        Member loginMember = memberService.findById(loginUserDto.getMemberId());
        basket.setName(addBasketDto.getName());
        basket.setMasterMember(loginMember);
        basket.setStartDate(addBasketDto.getStartDate());
        basket.setEndDate(addBasketDto.getEndDate());
        Basket saveBasket = basketService.addBasket(basket);
        return saveBasket;
    }

    @GetMapping("/baskets")
    public List<Basket> getBaskets(){
        return basketService.getBasket();
    }

    @PostMapping("/basket/{basketId}/join-request")
    public String signUpBasket(@IfLogin LoginUserDto loginUserDto, @PathVariable Long basketId){
        Basket findBasket = basketService.findById(basketId);
        Member loginMember = memberService.findById(loginUserDto.getMemberId());
        BasketMember basketMember = new BasketMember();
        basketMember.setBasket(findBasket);
        basketMember.setMember(loginMember);
        basketMemberService.add(basketMember);
        return "Success";
    }
}
