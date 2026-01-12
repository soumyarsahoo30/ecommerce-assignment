package com.ecommerce.inventory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.inventory.entity.InventoryBatch;
import com.ecommerce.inventory.repository.InventoryRepository;
import com.ecommerce.inventory.service.factory.InventoryHandlerFactory;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InventoryServiceImpl implements InventoryService{
	
	private final InventoryRepository repository;
    private final InventoryHandlerFactory factory;

	public InventoryServiceImpl(InventoryRepository repository, InventoryHandlerFactory factory) {
		this.repository = repository;
		this.factory = factory;
	}

	@Override
	public List<InventoryBatch> getBatches(Long productId) {
		return repository.findByProductIdOrderByExpiryDateAsc(productId);
	}

	@Override
	public void updateInventory(Long productId, int quantity) {
		log.info("Fetch inventory for productid: "+productId+"with quantity: "+quantity);
		factory.getHandler().updateInventory(productId, quantity);
	}

}
