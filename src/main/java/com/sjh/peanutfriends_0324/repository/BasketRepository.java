package com.sjh.peanutfriends_0324.repository;

import com.sjh.peanutfriends_0324.domain.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {

}
