package com.cars365.AuthService.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

public class UserLoginReq {

    private Long id;
    private String username;
    private String password;
    private List<String> roles;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return this.username;
    }


    public String getPassword() {
        return password;
    }

    public List<String> getRoles() {
        return roles;
    }
}
