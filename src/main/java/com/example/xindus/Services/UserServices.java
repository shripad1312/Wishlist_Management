package com.example.xindus.Services;

import com.example.xindus.Config.SecurityConfig;
import com.example.xindus.DTO.AddUserDto;
import com.example.xindus.Entity.User;
import com.example.xindus.Repositary.UserRepo;
import com.example.xindus.Transformers.UserTransFormer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices {
@Autowired
private SecurityConfig securityConfig;
    @Autowired
    private UserRepo userRepo;
    public String addUser(AddUserDto addUserDto)throws Exception{
        try{

            User user= UserTransFormer.convertToUser(addUserDto);
            userRepo.save(user);
            return "User Added Sucessfully";
        }catch (Exception e){
            throw new Exception("Failed To Save User Try Again");
        }
    }

    public List<String> getAllUserNames(){
        List<User> users = userRepo.findAll();
        List<String> userNames = new ArrayList<>();

        for(User user:users){
            userNames.add(user.getUsername());
        }
        return userNames;
    }

}
