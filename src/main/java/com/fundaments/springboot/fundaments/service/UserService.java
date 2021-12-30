package com.fundaments.springboot.fundaments.service;

import com.fundaments.springboot.fundaments.entity.User;
import com.fundaments.springboot.fundaments.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //metodos
    //esta anotacion  nos permite realizar un Rollback en caso de un error
    @Transactional
    public void saveTransactional(List<User> users) {
        users.stream()
                .peek(user -> LOG.info("USER INSERT: " + user))
                .forEach(userRepository::save);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
