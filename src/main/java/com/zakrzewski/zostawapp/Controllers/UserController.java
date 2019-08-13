package com.zakrzewski.zostawapp.Controllers;

import com.zakrzewski.zostawapp.Entities.UserModel;
import com.zakrzewski.zostawapp.Services.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    private UserServiceImpl userServiceImpl;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @RequestMapping(value = "/get/users", method = RequestMethod.GET)
    public List<String> getUsersInfo(){
        return userServiceImpl.getUsersInfo();
    }

    @RequestMapping(value = "/get/all-users", method = RequestMethod.GET)
    public List<UserModel> getAllUsers(){
        List<UserModel> ourUser = userServiceImpl.getAllUsers();
        return ourUser;
    }

    @RequestMapping(value = "/get/user/{id}", method = RequestMethod.GET)
    public UserModel getOneUser(@PathVariable Long id){
        return userServiceImpl.getOneUserInfo(id);
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public void addNewUser(@RequestBody UserModel userModel){
        userServiceImpl.addNewUserInfo(userModel);
        System.out.println(userModel.getSpecialUserId());
    }

    @RequestMapping(value = "/edit-user/{id}", method = RequestMethod.PUT)
    public void updateUser(@RequestBody UserModel userModel, @PathVariable Long id){
        userServiceImpl.editUser(id, userModel);
    }

    @RequestMapping(value = "/delete-user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        userServiceImpl.deleteUser(id);
    }
}
