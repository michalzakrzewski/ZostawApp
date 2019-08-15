package com.zakrzewski.zostawapp.Services;

import com.zakrzewski.zostawapp.Entities.UserModel;
import com.zakrzewski.zostawapp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<String> getUsersInfo(){
        List<String> showUsers = new ArrayList<>();
        List<UserModel> ourUser = userRepository.findAll();
        for (UserModel userModel : ourUser) {
            showUsers.add("User First Name: " + userModel.getFirstName());
            showUsers.add("User Last Name: " + userModel.getLastName());
            showUsers.add("User Phone Number: " + userModel.getPhoneNumber());
            showUsers.add("==============================================");
        }
        return showUsers;
    }

    public List<UserModel> getAllUsers(){
        List<UserModel> userModelList = userRepository.findAll();
        return userModelList;
    }

    public UserModel getOneUserInfo(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public UserModel addNewUserInfo(UserModel clientModel) {
        clientModel.setPasswordUser(new BCryptPasswordEncoder().encode(clientModel.getPassword()));
        return userRepository.save(clientModel);
    }

    public UserModel editUser(Long id, UserModel clientModel) {
        return userRepository.save(clientModel);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
