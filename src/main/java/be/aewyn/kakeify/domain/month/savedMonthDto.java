package be.aewyn.kakeify.domain.month;

import be.aewyn.kakeify.domain.entry.Entry;
import be.aewyn.kakeify.domain.recurringcost.RecurringCost;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public record savedMonthDto(
        LocalDate date,
        BigDecimal savingsGoal,
        Set<RecurringCost> recurringCosts,
        List<Entry> entries
) {
}
