package springboottransactionproject.services;

import springboottransactionproject.dtos.OrderRequest;
import springboottransactionproject.dtos.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);


}
