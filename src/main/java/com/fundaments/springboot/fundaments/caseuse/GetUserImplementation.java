package com.fundaments.springboot.fundaments.caseuse;

import com.fundaments.springboot.fundaments.entity.User;
import com.fundaments.springboot.fundaments.service.UserService;

import java.util.List;

public class GetUserImplementation implements GetUser{
    private UserService userService;

    public GetUserImplementation(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
