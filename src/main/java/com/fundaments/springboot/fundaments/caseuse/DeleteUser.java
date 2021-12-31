package com.fundaments.springboot.fundaments.caseuse;

import com.fundaments.springboot.fundaments.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {
    private UserService userService;

    public DeleteUser(UserService userService) {
        this.userService = userService;
    }

    public void remove(Long id) {
        this.userService.delete(id);
    }
}
