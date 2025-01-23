package com.cars365.SearchService.services;

import com.cars365.SearchService.entities.Inventory;
import com.cars365.SearchService.repositories.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory save(Inventory vehicle) {
        return inventoryRepository.save(vehicle);
    }

}
