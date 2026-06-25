package nst.assaf.assafbackend.dto;

import java.math.BigDecimal;

public record StatsDto(long orders, long pendingOrders, BigDecimal revenue, long products) {
}
