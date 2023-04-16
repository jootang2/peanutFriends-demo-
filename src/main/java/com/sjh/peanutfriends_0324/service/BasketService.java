package com.sjh.peanutfriends_0324.service;

import com.sjh.peanutfriends_0324.domain.Basket;
import com.sjh.peanutfriends_0324.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;

    public Basket addBasket(Basket basket) {
        Basket saveBasket = basketRepository.save(basket);
        return saveBasket;
    }

    public List<Basket> getBasket(){
        List<Basket> baskets = basketRepository.findAll();
        return baskets;
    }

    public Basket findById(Long basketId) {
        Optional<Basket> findBasket = basketRepository.findById(basketId);
        return findBasket.orElseThrow(()-> new IllegalArgumentException("없는 바스켓입니다."));
    }
}
