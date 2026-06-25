package nst.assaf.assafbackend.service;

import java.util.List;
import nst.assaf.assafbackend.dto.OrderCreateRequest;
import nst.assaf.assafbackend.dto.OrderDto;
import nst.assaf.assafbackend.dto.StatsDto;
import nst.assaf.assafbackend.model.OrderStatus;

public interface OrderService {
    OrderDto create(OrderCreateRequest request);

    List<OrderDto> findAll();

    OrderDto updateStatus(Long id, OrderStatus status);

    StatsDto stats();
}
