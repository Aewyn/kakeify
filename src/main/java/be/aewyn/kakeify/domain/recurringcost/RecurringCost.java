package be.aewyn.kakeify.domain.recurringcost;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public final class RecurringCost {
    String name;
    BigDecimal cost;
}
