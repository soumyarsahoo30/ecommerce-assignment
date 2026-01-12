package com.ecommerce.inventory.service.factory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class InventoryHandlerFactory {

	private final InventoryHandler handler;

	public InventoryHandlerFactory(@Qualifier("inventoryHandlerImpl") InventoryHandler handler) {
		this.handler = handler;
	}

	public InventoryHandler getHandler() {
		return handler;
	}

}
