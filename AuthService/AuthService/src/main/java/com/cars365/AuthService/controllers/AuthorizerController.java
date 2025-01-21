package com.cars365.AuthService.controllers;

import com.cars365.AuthService.dtos.AuthorizerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/authorizer")
public class AuthorizerController {

    @GetMapping
    public String authorizeRequest() {
        System.out.println("inside authorizer");
        return "Success";
    }
}
