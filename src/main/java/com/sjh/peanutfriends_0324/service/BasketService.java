package com.sjh.peanutfriends_0324.service;

import com.sjh.peanutfriends_0324.domain.Basket;
import com.sjh.peanutfriends_0324.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;

    public Basket addBasket(Basket basket) {
        Basket saveBasket = basketRepository.save(basket);
        return saveBasket;
    }
}
