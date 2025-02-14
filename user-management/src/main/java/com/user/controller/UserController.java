package com.user.controller;

import org.springframework.web.bind.annotation.RestController;

import com.user.entity.UserEntity;
import com.user.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    
    UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getUsers(){
        return userService.getUsers();
    }
    
    
}
