package com.fundaments.springboot.fundaments.caseuse;

import com.fundaments.springboot.fundaments.entity.User;
import com.fundaments.springboot.fundaments.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User user) {
        return userService.save(user);
    }
}
