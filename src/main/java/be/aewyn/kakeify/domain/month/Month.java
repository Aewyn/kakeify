package be.aewyn.kakeify.domain.month;

import be.aewyn.kakeify.domain.entry.Entry;
import be.aewyn.kakeify.domain.recurringcost.RecurringCost;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Builder
@Data
public class Month {
    //TODO Refactor to YearMonth?
    LocalDate date;
    BigDecimal savingsGoal;
    Set<RecurringCost> recurringCosts;
    List<Entry> entries;
}