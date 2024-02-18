package com.example.xindus.Config;

//import com.example.xindus.Services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.security.AuthProvider;


@Configuration
@EnableWebSecurity

public class SecurityConfig  {
//    @Autowired
//    private CustomUserDetailService customUserDetailService;
    public static final String[] urls={
       "/v3/api-docs/**",
        "/v2/api-docs/**",
        "/swagger-resources/**",
        "swagger-ui/**",
        "/webjars/**",
        "Public/**"
    };

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){

        return  new CustomUserDetailService();
    }


//    @Bean
//    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
//        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
//    }

    @Bean
    public AuthenticationProvider authProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
    http.csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers(urls).permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic()
            .and()
            .logout();


    return http.build();
}
}
