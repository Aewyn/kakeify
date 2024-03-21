package be.aewyn.kakeify.month;

import be.aewyn.kakeify.entry.Entry;
import be.aewyn.kakeify.recurring_cost.RecurringCost;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Builder
@Data
@Value
public class Month {
    LocalDate date;
    BigDecimal savingsGoal;
    Set<RecurringCost> recurringCosts;
    List<Entry> entries;
}
