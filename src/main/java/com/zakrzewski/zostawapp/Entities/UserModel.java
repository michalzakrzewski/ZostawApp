package com.zakrzewski.zostawapp.Entities;

import com.zakrzewski.zostawapp.Validations.PeselValidation;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

@Entity
@Table(name = "users")
public class UserModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_user", nullable = false)
    private String userLogin;

    @Column(name = "password_user", nullable = false)
    private String passwordUser;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "pesel_number", nullable = false)
    private String peselNumber;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "user_role", nullable = false)
    private String roleUser;

    @Column(name = "special_user_id", nullable = false)
    private int specialUserId;

    private static Random random = new Random();

    public UserModel(String userLogin, String passwordUser, String firstName, String lastName, String peselNumber, String phoneNumber, String roleUser){
        this.userLogin = userLogin;
        this.passwordUser = passwordEncoder().encode(passwordUser);
        this.firstName = firstName;
        this.lastName = lastName;
        this.peselNumber = PeselValidation.validatePeselNumber(peselNumber);
        this.phoneNumber = phoneNumber;
        this.roleUser = roleUser;
        this.specialUserId = random.nextInt(9999);
    }

    private int generateSpecialUserId() {
        return this.random.nextInt(9999);
    }

    public UserModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPeselNumber() {
        return peselNumber;
    }

    public void setPeselNumber(String peselNumber) {
        this.peselNumber = peselNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(String roleUser) {
        this.roleUser = roleUser;
    }

    public int getSpecialUserId() {
        return specialUserId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(roleUser));
    }

    @Override
    public String getPassword() {
        return passwordUser;
    }

    @Override
    public String getUsername() {
        return userLogin;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
