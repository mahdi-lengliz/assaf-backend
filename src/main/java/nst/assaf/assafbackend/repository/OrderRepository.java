package nst.assaf.assafbackend.repository;

import java.util.List;
import nst.assaf.assafbackend.model.CustomerOrder;
import nst.assaf.assafbackend.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {
    long countByStatus(OrderStatus status);

    List<CustomerOrder> findAllByOrderByCreatedAtDesc();
}
