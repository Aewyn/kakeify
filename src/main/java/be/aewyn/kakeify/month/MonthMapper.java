package be.aewyn.kakeify.month;

import be.aewyn.kakeify.entry.EntryMapper;
import be.aewyn.kakeify.recurring_cost.RecurringCostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MonthMapper {
    private final RecurringCostMapper recurringCostMapper;
    private final EntryMapper entryMapper;
    public Month toMonth(MonthEntity entity){
        return Month.builder()
                .date(entity.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .savingsGoal(entity.getSavingsGoal())
                .recurringCosts(recurringCostMapper.toRecurringCosts(entity.getRecurringCosts()))
                .entries(entryMapper.toEntries(entity.getEntryEntities()))
                .build();
    }

    public List<Month> toMonths(List<MonthEntity> entities){
        return entities.stream().map(this::toMonth).toList();
    }

    public MonthEntity toMonthEntity(Month pojo){
        return MonthEntity.builder()
                .date(Date.from(pojo.getDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()))
                .savingsGoal(pojo.getSavingsGoal())
                .recurringCosts(recurringCostMapper.toRecurringCostEntities(pojo.getRecurringCosts()))
                .entryEntities(entryMapper.toEntryEntities(pojo.getEntries()))
                .build();
    }

    public List<MonthEntity> toMonthEntities(List<Month> pojos){
        return pojos.stream().map(this::toMonthEntity).toList();
    }
}
