package springboottransactionproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboottransactionproject.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
