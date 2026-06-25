package nst.assaf.assafbackend.mapper;

import nst.assaf.assafbackend.dto.OrderDto;
import nst.assaf.assafbackend.dto.OrderItemDto;
import nst.assaf.assafbackend.model.CustomerOrder;
import nst.assaf.assafbackend.model.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderDto toDto(CustomerOrder order) {
        return new OrderDto(
                order.getId(),
                order.getOrderNumber(),
                order.getCustomerName(),
                order.getCustomerEmail(),
                order.getCustomerPhone(),
                order.getAddress(),
                order.getCity(),
                order.getNotes(),
                order.getTotal(),
                order.getShipping(),
                order.getStatus(),
                order.getCreatedAt(),
                order.getItems().stream().map(this::toItemDto).toList()
        );
    }

    private OrderItemDto toItemDto(OrderItem item) {
        return new OrderItemDto(
                item.getProductId(),
                item.getProductName(),
                item.getQuantity(),
                item.getUnitPrice(),
                item.getPerfumeSize(),
                item.getImageUrl(),
                item.getEmoji()
        );
    }
}
