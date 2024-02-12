package springboottransactionproject.dtos;

import lombok.Getter;
import lombok.Setter;
import springboottransactionproject.entities.Order;
import springboottransactionproject.entities.Payment;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
