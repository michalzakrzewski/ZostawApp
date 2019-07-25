package com.zakrzewski.zostawapp.Controllers;

import com.zakrzewski.zostawapp.Entities.UserModel;
import com.zakrzewski.zostawapp.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {

    private UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @RequestMapping(value = "/get/all-users", method = RequestMethod.GET)
    public List<UserModel> getAllUsers(){
        return userServiceImpl.getAllUsers();
    }

    @RequestMapping(value = "/get/user/{id}", method = RequestMethod.GET)
    public UserModel getOneUser(@PathVariable Long id){
        return userServiceImpl.getOneUserInfo(id);
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public void addNewUser(@RequestBody UserModel userModel){
        userServiceImpl.addNewUserInfo(userModel);
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
