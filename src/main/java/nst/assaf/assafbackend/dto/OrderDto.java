package nst.assaf.assafbackend.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import nst.assaf.assafbackend.model.OrderStatus;

public record OrderDto(
        Long id,
        String orderNumber,
        String customerName,
        String customerEmail,
        String customerPhone,
        String address,
        String city,
        String notes,
        BigDecimal total,
        BigDecimal shipping,
        OrderStatus status,
        Instant createdAt,
        List<OrderItemDto> items
) {
}
