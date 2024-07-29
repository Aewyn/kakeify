package be.aewyn.kakeify.domain.month;

import be.aewyn.kakeify.domain.entry.Entry;
import be.aewyn.kakeify.domain.recurringcost.RecurringCost;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Set;

@Builder
@Data
public class Month {
    Long id;
    YearMonth date;
    BigDecimal income;
    BigDecimal savingsGoal;
    Set<RecurringCost> recurringCosts;
    List<Entry> entries;
}