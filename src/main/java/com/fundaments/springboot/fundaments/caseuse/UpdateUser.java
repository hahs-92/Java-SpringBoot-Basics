package com.fundaments.springboot.fundaments.caseuse;

import com.fundaments.springboot.fundaments.entity.User;
import com.fundaments.springboot.fundaments.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User update(User user, Long id) {
        return  userService.update(user, id);
    }
}
