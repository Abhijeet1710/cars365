package com.cars365.AuthService.controllers;

import com.cars365.AuthService.dtos.UserLoginReq;
import com.cars365.AuthService.dtos.UserSignupReq;
import com.cars365.AuthService.entities.User;
import com.cars365.AuthService.services.JwtUtilsService;
import com.cars365.AuthService.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    JwtUtilsService jwtUtilsService;

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginReq userLoginReq) {
        System.out.println("userName in controller "+userLoginReq.getUsername());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userLoginReq.getUsername(), userLoginReq.getPassword())
            );
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(jwtUtilsService.generateToken(userLoginReq.getUsername()), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserSignupReq userSignupReq) {
        try{
        System.out.println("Inside /signup");
            User createdUser = userDetailsServiceImpl.createUser(userSignupReq);
            return new ResponseEntity<>(createdUser, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
