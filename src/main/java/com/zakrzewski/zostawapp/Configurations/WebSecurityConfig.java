package com.zakrzewski.zostawapp.Configurations;


import com.zakrzewski.zostawapp.Entities.UserModel;
import com.zakrzewski.zostawapp.Repositories.UserRepository;
import com.zakrzewski.zostawapp.Services.UserDetailsServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsServiceImpl userDetailsService;
    private UserRepository userRepository;

    @Autowired
    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService, UserRepository userRepository) {
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/get/allusers").permitAll()
                .antMatchers("/get/user/{id}").hasRole("ADMIN")
                .antMatchers("/add/user").hasRole("ADMIN")
                .antMatchers("/edit/user/{id}").hasRole("ADMIN")
                .antMatchers("/delete/user/{id}").hasRole("ADMIN")
                .and()
                .formLogin().permitAll()
                .and()
                .csrf().disable();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createFinalUsers(){
        UserModel userUserModel  = new UserModel("user", "test", "User", "User", "22031129488", "789789789", "ROLE_USER");
        UserModel adminAdminModel = new UserModel("admin", "test", "Admin", "Admin", "20111679638", "456789123", "ROLE_ADMIN");
        userRepository.save(userUserModel);
        userRepository.save(adminAdminModel);
    }
}
