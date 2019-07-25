package com.zakrzewski.zostawapp.Repositories;

import com.zakrzewski.zostawapp.Entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByUserLogin(String userLogin);
}
