package com.ecommerce.inventory.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.inventory.dto.InventoryRequest;
import com.ecommerce.inventory.entity.InventoryBatch;
import com.ecommerce.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @GetMapping("/{productId}")
    public List<InventoryBatch> getInventory(@PathVariable Long productId) {
        return service.getBatches(productId);
    }

    @PostMapping("/update")
    public void updateInventory(@RequestBody InventoryRequest request) {
        service.updateInventory(request.getProductId(), request.getQuantity());
    }

}
