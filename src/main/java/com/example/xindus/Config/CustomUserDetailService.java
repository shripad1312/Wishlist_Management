package com.example.xindus.Config;

import com.example.xindus.Entity.User;
import com.example.xindus.Repositary.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.findByUsername(username);//by name to username
        if(user==null){
            throw new UsernameNotFoundException("BAD CREDENTIALS");
        }
        return new CustomUserDetail(user);
    }
}
