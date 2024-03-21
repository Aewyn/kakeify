package be.aewyn.kakeify.recurring_cost;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;

@Builder
@Data
@Value
public class RecurringCost {
    String name;
    BigDecimal cost;
}
