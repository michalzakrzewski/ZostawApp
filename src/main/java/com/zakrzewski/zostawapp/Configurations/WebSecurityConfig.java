package com.zakrzewski.zostawapp.Configurations;


import com.zakrzewski.zostawapp.Entities.UserModel;
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

    private String versionApp = "/api/v1";

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
                .antMatchers(versionApp + "/get/users").hasRole("USER")
                .antMatchers(versionApp + "/get/all-users").hasRole("ADMIN")
                .antMatchers(versionApp + "/get/user/{id}").hasRole("ADMIN")
                .antMatchers(versionApp + "/add/user").hasRole("ADMIN")
                .antMatchers(versionApp + "/edit-user/{id}").hasRole("ADMIN")
                .antMatchers(versionApp + "/delete-user/{id}").hasRole("ADMIN")
                .and()
                .formLogin().permitAll()
                .and()
                .csrf().disable();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createFinalUsers(){
        UserModel userUserModel  = new UserModel("user", passwordEncoder().encode("test"), "User", "User", "22031129488", "789789789", "ROLE_USER");
        UserModel adminAdminModel = new UserModel("admin", passwordEncoder().encode("test"), "Admin", "Admin", "20111679638", "456789123", "ROLE_ADMIN");
        userRepository.save(userUserModel);
        userRepository.save(adminAdminModel);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
