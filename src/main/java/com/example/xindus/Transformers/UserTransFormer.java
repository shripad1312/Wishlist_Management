package com.example.xindus.Transformers;

import com.example.xindus.Config.SecurityConfig;
import com.example.xindus.DTO.AddUserDto;
import com.example.xindus.Entity.User;
import com.example.xindus.Exceptions.ConvertToUserException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTransFormer {

    public static User convertToUser(AddUserDto userDto)throws Exception{
        try{
            SecurityConfig securityConfig=new SecurityConfig();
            User user=User.builder().
                    name(userDto.getName())
                    .username(userDto.getUsername())
                    .password(securityConfig.passwordEncoder().encode(userDto.getPassword()))
                    .build();
            return user;
        }catch (Exception e){
            throw new ConvertToUserException("Failed To Convert Into User In TransFormer");
        }

    }
}
