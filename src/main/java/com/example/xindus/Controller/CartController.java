package com.example.xindus.Controller;

import com.example.xindus.Services.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/wishlists")

public class CartController {

    @Autowired
    private CartService cartService;

    //for addinf products to users cart this is the api-(http://localhost:8080/api/wishlists/addToCart/{product_id})

    @PostMapping("/addToCart/{Product_id}")
    public ResponseEntity addToCart(@PathVariable("Product_id")Integer id1){
        try{

            ResponseEntity st= cartService.addtocart(id1);
            return new ResponseEntity(st, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


//(for getting all user wishlist this the api):- http://localhost:8080/api/wishlists/getList


    @GetMapping("/getList")
    public ResponseEntity getList()throws Exception{
        try{
            Authentication auth= SecurityContextHolder.getContext().getAuthentication();
            if(auth.isAuthenticated()){
                ResponseEntity WishList= cartService.getlist();
                return new ResponseEntity(WishList,HttpStatus.OK);
            }else{
                return new ResponseEntity("Log in First With Proper Credentials",HttpStatus.OK);
            }
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }


//(By giving product id we can delete product this is the api):-(http://localhost:8080/api/wishlists/delete/{product_id})

    @DeleteMapping("/delete/{product_id}")
    public ResponseEntity delete(@PathVariable("product_id") Integer id)throws Exception{
        try{
            ResponseEntity ans= cartService.delete(id);
            return new ResponseEntity(ans,HttpStatus.OK);
        }catch(Exception  e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
}

