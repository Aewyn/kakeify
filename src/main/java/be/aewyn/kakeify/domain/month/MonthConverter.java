package be.aewyn.kakeify.domain.month;

import be.aewyn.kakeify.domain.entry.EntryConverter;
import be.aewyn.kakeify.domain.recurringcost.RecurringCostConverter;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Component
public abstract class MonthConverter {

    public static Month toMonth(MonthEntity entity) {
        return Month.builder()
                .date(entity.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .savingsGoal(entity.getSavingsGoal())
                .recurringCosts(RecurringCostConverter.toRecurringCosts(entity.getRecurringCosts()))
                .entries(EntryConverter.toEntries(entity.getEntryEntities()))
                .build();
    }

    public static List<Month> toMonths(List<MonthEntity> entities) {
        return entities.stream().map(MonthConverter::toMonth).toList();
    }

    public static MonthEntity toMonthEntity(Month pojo) {
        return MonthEntity.builder()
                .date(Date.from(pojo.getDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()))
                .savingsGoal(pojo.getSavingsGoal())
                .recurringCosts(RecurringCostConverter.toRecurringCostEntities(pojo.getRecurringCosts()))
                .entryEntities(EntryConverter.toEntryEntities(pojo.getEntries()))
                .build();
    }

    public static List<MonthEntity> toMonthEntities(List<Month> pojos) {
        return pojos.stream().map(MonthConverter::toMonthEntity).toList();
    }
}
