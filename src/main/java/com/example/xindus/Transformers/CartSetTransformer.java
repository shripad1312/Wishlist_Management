package com.example.xindus.Transformers;

import com.example.xindus.Entity.Cart;
import com.example.xindus.Entity.Product;
import com.example.xindus.Entity.User;

public class CartSetTransformer {
    public static Cart setCart(User u, Product p)throws Exception{
        try{
            Cart cart=Cart.builder()
                    .user(u)
                    .product(p)
                    .build();
            return cart;
        }catch (Exception e){
            throw new Exception("Error while Setting a cart object in add to cart post api");
        }

    }
}
