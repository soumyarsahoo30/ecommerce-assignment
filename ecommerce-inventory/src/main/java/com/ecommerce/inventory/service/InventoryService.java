

package com.ecommerce.inventory.service;

import java.util.List;

import com.ecommerce.inventory.entity.InventoryBatch;

public interface InventoryService {

	List<InventoryBatch> getBatches(Long productId);
    void updateInventory(Long productId, int quantity);

}
