package com.cars365.AuthService.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("private")
public class privateController {

    @GetMapping
    public ResponseEntity<?> ping() {
        return new ResponseEntity<>("Reached", HttpStatus.OK);
    }
}
