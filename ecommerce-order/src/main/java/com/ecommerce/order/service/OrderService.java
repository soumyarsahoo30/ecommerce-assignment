package com.ecommerce.order.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ecommerce.order.dto.InventoryBatch;
import com.ecommerce.order.dto.InventoryRequest;
import com.ecommerce.order.dto.OrderRequest;
import com.ecommerce.order.entity.Order;
import com.ecommerce.order.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {

	private final OrderRepository orderRepository;
	private final WebClient webClient;

	public OrderService(OrderRepository orderRepository, WebClient webClient) {
		this.orderRepository = orderRepository;
		this.webClient = webClient;
	}

	public Order placeOrder(OrderRequest request) {

		InventoryRequest inventoryRequest = new InventoryRequest(request.getProductId(), request.getQuantity());

		placeOrder(inventoryRequest); 
		InventoryBatch inventoryDetails = getInventoryDetails(request.getProductId());
																														
		Order order = new Order();
		order.setProductId(request.getProductId());
		order.setProductName(inventoryDetails.getProductName());
		order.setQuantity(request.getQuantity());
		order.setStatus("PLACED");
		order.setOrderDate(LocalDate.now());

		return orderRepository.save(order);
	}

	private InventoryBatch getInventoryDetails(Long productId) {
		return webClient.get()
                .uri("http://localhost:8081/inventory/{productId}", productId)
                .retrieve()
               . bodyToFlux(InventoryBatch.class)
                .collectList()
                .block().get(0);
	}

	private void placeOrder(InventoryRequest inventoryRequest) {
		webClient.post()
		.uri("http://localhost:8081/inventory/update").bodyValue(inventoryRequest)
		.retrieve()
		.toBodilessEntity()
		.block();
	}
}
