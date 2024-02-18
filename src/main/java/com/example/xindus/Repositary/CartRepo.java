package com.example.xindus.Repositary;

import com.example.xindus.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer>{
    List<Cart> findByUserId(Integer id);
    List<Cart> findByProductId(Integer id);
    Cart  findByUserIdAndProductId(Long u1,Integer p1);
}
