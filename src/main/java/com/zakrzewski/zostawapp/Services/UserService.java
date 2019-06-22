package com.zakrzewski.zostawapp.Services;

import com.zakrzewski.zostawapp.Entities.UserModel;
import com.zakrzewski.zostawapp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getAllUsers(){
        List<UserModel> userModelList = userRepository.findAll();
        return userModelList;
    }

    public UserModel getOneUserInfo(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public void addNewUserInfo(UserModel clientModel) {
        userRepository.save(clientModel);
    }

    public void editUser(Long id, UserModel clientModel) {
        userRepository.save(clientModel);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
