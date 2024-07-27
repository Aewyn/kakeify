package be.aewyn.kakeify.domain.recurringcost;

import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public abstract class RecurringCostConverter {

    public static RecurringCost toRecurringCost(RecurringCostEntity entity) {
        return RecurringCost.builder()
                .name(entity.getName())
                .cost(entity.getCost())
                .build();
    }

    public static Set<RecurringCost> toRecurringCosts(Set<RecurringCostEntity> entities) {
        return entities.stream().map(RecurringCostConverter::toRecurringCost).collect(Collectors.toSet());
    }

    public static RecurringCostEntity toRecurringCostEntity(RecurringCost pojo) {
        return RecurringCostEntity.builder()
                .name(pojo.getName())
                .cost(pojo.getCost())
                .build();
    }

    public static Set<RecurringCostEntity> toRecurringCostEntities(Set<RecurringCost> pojos) {
        return pojos.stream().map(RecurringCostConverter::toRecurringCostEntity).collect(Collectors.toSet());
    }
}
