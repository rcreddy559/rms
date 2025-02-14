package com.user.service;

import java.util.List;

import com.user.entity.UserEntity;
import com.user.repositry.UserRepositry;
import org.springframework.stereotype.Service;

@Service
public class UserService {
   private final UserRepositry userRepositry;

    UserService(UserRepositry userRepositry){
        this.userRepositry = userRepositry;
    }

    public List<UserEntity> getUsers(){
        return userRepositry.findAll();
    }
}
