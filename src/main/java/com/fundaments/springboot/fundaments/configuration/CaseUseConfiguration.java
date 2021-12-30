package com.fundaments.springboot.fundaments.configuration;

import com.fundaments.springboot.fundaments.caseuse.GetUser;
import com.fundaments.springboot.fundaments.caseuse.GetUserImplementation;
import com.fundaments.springboot.fundaments.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUser getUser(UserService userService) {
        return new GetUserImplementation(userService);
    }
}

