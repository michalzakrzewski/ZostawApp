package com.zakrzewski.zostawapp.Repositories;

import com.zakrzewski.zostawapp.Entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByUserLogin(String loginUser);
}
