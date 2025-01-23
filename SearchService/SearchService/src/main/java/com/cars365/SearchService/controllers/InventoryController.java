package com.cars365.SearchService.controllers;

import com.cars365.SearchService.entities.Inventory;
import com.cars365.SearchService.services.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public String getAllVehicles() {
        return "Veh1, Vh2";
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveVehicle(@RequestBody Inventory vehicle) {
        try {
            Inventory savedVehicle = inventoryService.save(vehicle);
            return new ResponseEntity<>(savedVehicle, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error in save" + e);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
