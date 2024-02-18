package com.example.xindus.Controller;


import com.example.xindus.DTO.AddUserDto;
import com.example.xindus.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Public/User")

public class UserController {

    @Autowired
    private UserServices userService;


    //this is post req used to add users in DB(http://localhost:8080/Public/User/add)
    @PostMapping("/add")
    public ResponseEntity<String> addAuthor(@RequestBody AddUserDto user){
        try{
            String result = userService.addUser(user);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }


    }

    @GetMapping("/findAllUser")
    public List<String> getAllAuthorNames(){

        return userService.getAllUserNames();
    }
}
