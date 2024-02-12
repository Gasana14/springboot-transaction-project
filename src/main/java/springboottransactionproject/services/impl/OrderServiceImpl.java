package springboottransactionproject.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboottransactionproject.dtos.OrderRequest;
import springboottransactionproject.dtos.OrderResponse;
import springboottransactionproject.entities.Order;
import springboottransactionproject.entities.Payment;
import springboottransactionproject.exceptions.PaymentException;
import springboottransactionproject.repositories.OrderRepository;
import springboottransactionproject.repositories.PaymentRepository;
import springboottransactionproject.services.OrderService;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    @Transactional // we are using transaction to prevent data inconsistency so order and payment must be saved all together
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if(!payment.getType().equalsIgnoreCase("DEBIT")){
            throw new PaymentException("Payment card type do not support");
        }else{
            payment.setOrderId(order.getId());
            paymentRepository.save(payment);
        }

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("Successfully");

        return orderResponse;
    }
}
