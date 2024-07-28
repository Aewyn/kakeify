package be.aewyn.kakeify.domain.month;

import be.aewyn.kakeify.domain.entry.Entry;
import be.aewyn.kakeify.domain.recurringcost.RecurringCost;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Set;

public record SavedMonthDto(
        YearMonth yearMonth,
        BigDecimal income,
        BigDecimal savingsGoal,
        Set<RecurringCost> recurringCosts,
        List<Entry> entries
) {

    public static SavedMonthDto createFromMonth(Month month) {
        return new SavedMonthDto(month.date, month.income, month.savingsGoal, month.recurringCosts, month.entries);
    }
}
