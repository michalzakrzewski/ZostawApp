package com.zakrzewski.zostawapp.Controllers;

import com.zakrzewski.zostawapp.Entities.UserModel;
import com.zakrzewski.zostawapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/get/allusers", method = RequestMethod.GET)
    public List<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/get/user/{id}", method = RequestMethod.GET)
    public UserModel getOneUser(@PathVariable Long id){
        return userService.getOneUserInfo(id);
    }

    @RequestMapping(value = "/add/user", method = RequestMethod.POST)
    public void addNewUser(@RequestBody UserModel userModel){
        userService.addNewUserInfo(userModel);
    }

    @RequestMapping(value = "/edit/user/{id}", method = RequestMethod.PUT)
    public void updateUser(@RequestBody UserModel userModel, @PathVariable Long id){
        userService.editUser(id, userModel);
    }

    @RequestMapping(value = "/delete/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
