package nst.assaf.assafbackend.dto;

import java.math.BigDecimal;

public record OrderItemDto(
        Long productId,
        String productName,
        Integer quantity,
        BigDecimal unitPrice,
        Integer perfumeSize,
        String imageUrl,
        String emoji
) {
}
