package com.example.xindus.Services;

import com.example.xindus.DTO.ProductList;
import com.example.xindus.Entity.Cart;
import com.example.xindus.Entity.Product;
import com.example.xindus.Entity.User;
import com.example.xindus.Exceptions.ProductNotFoundException;
import com.example.xindus.Exceptions.ProductNotFoundInCartException;
import com.example.xindus.Exceptions.UserNotFoundException;
import com.example.xindus.Repositary.UserRepo;
import com.example.xindus.Repositary.CartRepo;
import com.example.xindus.Repositary.ProductRepo;
import com.example.xindus.Transformers.CartSetTransformer;
import com.example.xindus.Transformers.productListTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private ProductRepo productrepo;

    @Autowired
    private UserRepo userrepo;

    @Autowired
    private CartRepo cartrepo;


    public ResponseEntity addtocart(int pid)throws Exception{
        //Tring to add product in cart with proper credential
        try{
            Authentication auth= SecurityContextHolder.getContext().getAuthentication();
            if(auth==null){
                throw  new UserNotFoundException("User Not Found");
            }

            User user= userrepo.findByUsername(auth.getName());
            Optional<Product>optionalProduct= productrepo.findById(pid);



            if(!optionalProduct.isPresent()){
                throw new ProductNotFoundException("Product Not Found");
            }

            //getting actaul user and product here
            Product product=optionalProduct.get();

            //retriving cartList of user for adding product into wishlist
            List<Cart>cartList=user.getCartItems();

           /* For loop checking product alredy exist or not if exist then adding its
             quntity of same product insted of addind seperate product*/

            for(Cart cart:cartList){
                Product pro= cart.getProduct();
                if(pro.equals(product)){
                    return new ResponseEntity("Product Already Exist Qty Increased By 1", HttpStatus.OK);
                }
            }

            // creating obj of cart for saving in Cart DB
            Cart cart= CartSetTransformer.setCart(user,product);


//       user.getCartItems().add(crt);->Due To Bi-directional Mapping No Need Of This It Will Automatically Added Into User
            //Data is saved in Cart
            cartrepo.save(cart);
            return new ResponseEntity("Product Added Sucessfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity getlist()throws Exception{
        //Checking User Is Authenticated or Not
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        if(auth==null){
            throw  new UserNotFoundException("User Not Found");
        }

        //Retriving User By Username
       User user= userrepo.findByUsername(auth.getName());

       if(user==null){
           throw new UserNotFoundException("User Not Found");//If user is null then throwing error
       }

        //Creating ArrayList For Adding WishListItems
        ArrayList<ProductList>listOfProducts=new ArrayList<>();

        List<Cart>cartList=user.getCartItems();//Retriving WishList Of Item From User
        if(cartList.isEmpty()){
            return new ResponseEntity("Your Cart Is Empty",HttpStatus.OK);
        }

        for(Cart Item:cartList){//Adding ProductIn User
            try{
                //Transfering Our Products Into ProductList DTO Because It Is Response Object
                ProductList productlist=productListTransformer.cartItemToProductList(Item);
                listOfProducts.add(productlist);
            }catch (Exception e){
                throw new Exception(e.getMessage());
            }
        }

        return new ResponseEntity(listOfProducts,HttpStatus.OK);
    }


    public ResponseEntity delete(int pid) throws Exception{
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        if(auth==null){
            throw  new UserNotFoundException("User Not Found");
        }

        Optional<Product> optionalProduct= productrepo.findById(pid);

        if(!optionalProduct.isPresent()){
            throw new ProductNotFoundException("Product Not Found");
        }

        User user=userrepo.findByUsername(auth.getName());
        Product product=optionalProduct.get();

        try{
            //Getting Exact Cart Using UserDetails and ProductDetails
            long uid=user.getId();
            Cart cart= cartrepo.findByUserIdAndProductId(uid,pid);

            if(cart==null){
                throw new Exception("Item Not Found");
            }

            //Removing Cart Item From User WishList And Product List Also
            user.getCartItems().remove(cart);
            product.getCartList().remove(cart);

            cartrepo.delete(cart);//Deleting Exact Entry From Cart Due to Bidirectional Mapping dont Need Of Saving User And Product
//
            return new ResponseEntity("Product Deleted Sucessfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(new ProductNotFoundInCartException("Product is Not In Your WishList"),HttpStatus.BAD_REQUEST);

        }

    }

}
