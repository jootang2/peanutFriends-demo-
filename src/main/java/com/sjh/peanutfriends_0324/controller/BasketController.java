package com.sjh.peanutfriends_0324.controller;

import com.sjh.peanutfriends_0324.domain.Basket;
import com.sjh.peanutfriends_0324.dto.AddBasketDto;
import com.sjh.peanutfriends_0324.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BasketController {

    private final BasketService basketService;
    
    @PostMapping("/basket/create")
    public Basket addBasket(@RequestBody AddBasketDto addBasketDto) {
        Basket basket = new Basket();
        basket.setName(addBasketDto.getName());
        basket.setStartDate(addBasketDto.getStartDate());
        basket.setEndDate(addBasketDto.getEndDate());
        Basket saveBasket = basketService.addBasket(basket);
        return saveBasket;
    }
}
