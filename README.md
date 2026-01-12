# ecommerce-assignment

This repo has inventory and order services



Start Inventory Service

Service runs on http://localhost:8081



Start Order Service

Service runs on http://localhost:8082



Verify Inventory API

GET http://localhost:8081/inventory/1005



Place order

POST http://localhost:8082/placeorder



body:



{ 

"productId": 1002, 

"quantity": 1000

} 





