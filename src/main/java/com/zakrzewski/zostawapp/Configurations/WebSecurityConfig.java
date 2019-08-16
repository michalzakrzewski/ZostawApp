package com.zakrzewski.zostawapp.Configurations;


import com.zakrzewski.zostawapp.Entities.AdvertisementModel;
import com.zakrzewski.zostawapp.Entities.UserModel;
import com.zakrzewski.zostawapp.Repositories.AdvertisementRepository;
import com.zakrzewski.zostawapp.Repositories.UserRepository;
import com.zakrzewski.zostawapp.Services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsServiceImpl userDetailsService;
    private UserRepository userRepository;

    private AdvertisementRepository advertisementRepository;

    private String versionApp = "/api";

    @Autowired
    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService, UserRepository userRepository, AdvertisementRepository advertisementRepository) {
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
        this.advertisementRepository = advertisementRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(versionApp + "/get/users").permitAll()
                .antMatchers(versionApp + "/get/all-users").hasRole("ADMIN")
                .antMatchers(versionApp + "/get/user/{id}").hasRole("ADMIN")
                .antMatchers(versionApp + "/add-user").hasRole("ADMIN")
                .antMatchers(versionApp + "/edit-user/{id}").hasRole("ADMIN")
                .antMatchers(versionApp + "/delete-user/{id}").hasRole("ADMIN")
                .antMatchers(versionApp + "/get/advertisement-user/{signature}").permitAll()
                .antMatchers(versionApp + "/get/all-advertisement").permitAll()
                .antMatchers(versionApp + "/get/advertisement/{id}").permitAll()
                .antMatchers(versionApp + "/add-advertisement").hasRole("USER")
                .antMatchers(versionApp + "/edit-advertisement/{id}").hasRole("ADMIN")
                .antMatchers(versionApp + "/delete-advertisement/{id}").hasRole("ADMIN")
                .and()
                .formLogin().permitAll()
                .and()
                .csrf().disable();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createFinalUsersAndAdvertisement(){
        UserModel userUserModel  = new UserModel("user", "test", "User", "User", "22031129488", "789789789", "ROLE_USER");
        UserModel adminAdminModel = new UserModel("admin", "test", "Admin", "Admin", "20111679638", "456789123", "ROLE_ADMIN");
        AdvertisementModel advertisementOne = new AdvertisementModel("Ogłoszenie nr 1", userUserModel.getFirstName());
        AdvertisementModel advertisementTwo = new AdvertisementModel("Ogłoszenie nr 2", adminAdminModel.getFirstName());
        userRepository.save(userUserModel);
        userRepository.save(adminAdminModel);

        advertisementRepository.save(advertisementOne);
        advertisementRepository.save(advertisementTwo);

    }
}
