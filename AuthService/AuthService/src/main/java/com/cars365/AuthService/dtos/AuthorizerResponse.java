package com.cars365.AuthService.dtos;

import java.util.List;

public class AuthorizerResponse {
    String isAuthorized;
    List<String> roles;

    public AuthorizerResponse(String isAuthorized, List<String> roles) {
        this.isAuthorized = isAuthorized;
        this.roles = roles;
    }
}
