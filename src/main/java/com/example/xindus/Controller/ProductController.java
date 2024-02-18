package com.example.xindus.Controller;

import com.example.xindus.Entity.Product;
import com.example.xindus.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Public/Product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //This url is for adding product into cart (http://localhost:8080/Public/Product/product)
    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody Product product){

        String result = productService.addProduct(product);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

}
