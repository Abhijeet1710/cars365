package com.cars365.SearchService.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vehicles")
public class InventoryController {

    @GetMapping
    public String getAllVehicles() {
        return "Veh1, Vh2";
    }

}
