package be.aewyn.kakeify.domain.month;

import be.aewyn.kakeify.domain.entry.EntryConverter;
import be.aewyn.kakeify.domain.recurringcost.RecurringCostConverter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Component
public abstract class MonthConverter {

    public static Month toMonth(MonthEntity monthEntity) {
        return Month.builder()
                .id(monthEntity.getId())
                .date(YearMonth.of(monthEntity.getDate().getYear(), monthEntity.getDate().getMonth()))
                .income(monthEntity.getIncome())
                .savingsGoal(monthEntity.getSavingsGoal())
                .recurringCosts(RecurringCostConverter.toRecurringCosts(monthEntity.getRecurringCosts()))
                .entries(EntryConverter.toEntries(monthEntity.getEntryEntities()))
                .build();
    }

    public static List<Month> toMonths(List<MonthEntity> monthEntityList) {
        return monthEntityList.stream().map(MonthConverter::toMonth).toList();
    }

    public static MonthEntity toMonthEntity(Month month) {
        return MonthEntity.builder()
                .date(LocalDate.of(month.date.getYear(), month.date.getMonth(), 1))
                .income(month.income)
                .savingsGoal(month.getSavingsGoal())
                .recurringCosts(RecurringCostConverter.toRecurringCostEntities(month.getRecurringCosts()))
                .entryEntities(EntryConverter.toEntryEntities(month.getEntries()))
                .build();
    }

    public static List<MonthEntity> toMonthEntities(List<Month> monthList) {
        return monthList.stream().map(MonthConverter::toMonthEntity).toList();
    }
}
