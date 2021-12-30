package com.fundaments.springboot.fundaments.controller;

import com.fundaments.springboot.fundaments.caseuse.GetUser;
import com.fundaments.springboot.fundaments.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //hereda de @Controller y los metodos que creemos se formateen a JSON
@RequestMapping("/api/users")//ruta http://localhost:8081/app/api/users/
public class UserRestController {
    private GetUser getUser;

    public UserRestController(GetUser getUser) {
        this.getUser = getUser;
    }

    @GetMapping("/") //ruta
    List<User> get() {
        return getUser.getAll();
    }

}
