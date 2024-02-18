package com.example.xindus.Transformers;

import com.example.xindus.DTO.ProductList;
import com.example.xindus.Entity.Cart;
import com.example.xindus.Exceptions.ProductListException;

public class productListTransformer {

   public static ProductList cartItemToProductList(Cart cart)throws Exception{

       try {
           ProductList productItem=ProductList.builder()
                   .id(cart.getProduct().getId())
                   .name(cart.getProduct().getName())
                   .qty(cart.getProduct().getQty())
                   .build();
           return productItem;
       }catch (Exception e){
           throw new ProductListException("Error Occured In Transforming");
       }


    }
}
