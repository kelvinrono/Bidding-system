package com.bidding.platform.controllers;

import com.bidding.platform.models.User;
import com.bidding.platform.objects.UserObject;
import com.bidding.platform.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/save-user")
    public HashMap saveUser(@RequestBody UserObject userObject){
        return userService.saveUser(userObject);
    }

    @PostMapping("/login-user")
    public HashMap login(@RequestBody UserObject userObject){
        return userService.loginUser(userObject);
    }

    @GetMapping("/get-user/{id}")
    public User getUser(@PathVariable("id") long id){
       return userService.getSingleUser(id);
    }

    @GetMapping("/get-all-users")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

}
