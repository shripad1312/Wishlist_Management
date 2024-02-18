package com.example.xindus.Services;

import com.example.xindus.Entity.Product;
import com.example.xindus.Repositary.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepo pr;

    public String addProduct(Product product){
        try{
          pr.save(product);
          return "added product sucessfully";
        }catch(Exception e){
            return "Not added";
        }
    }
}
