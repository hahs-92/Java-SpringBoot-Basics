package com.fundaments.springboot.fundaments.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding //construye las propiedades
@ConfigurationProperties(prefix = "user") // lee las propiedades del archivo aplication.properties con ayuda de la GeneralConfiguration
public class UserPojo {
    private String username;
    private String password;

    public UserPojo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
