package com.ecommerce.inventory.service.factory;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ecommerce.inventory.entity.InventoryBatch;
import com.ecommerce.inventory.repository.InventoryRepository;

@Component
public class InventoryHandlerImpl implements InventoryHandler{
	
	 private final InventoryRepository repository;
	 
	public InventoryHandlerImpl(InventoryRepository repository) {
		this.repository = repository;
	}

	@Override
	public void updateInventory(Long productId, int quantity) {
		
		 List<InventoryBatch> batches =
	                repository.findByProductIdOrderByExpiryDateAsc(productId);

	        for (InventoryBatch batch : batches) {
	            if (quantity <= 0) break;

	            
	            int leftAmount  = Math.min(batch.getQuantity(), quantity);
	            batch.setQuantity(batch.getQuantity() - leftAmount);
	            quantity = quantity - leftAmount;
	            repository.save(batch);
	        }

	        if (quantity > 0) {
	            throw new RuntimeException("Insufficient inventory available");
	        } 
	}

}
