package be.aewyn.kakeify.recurring_cost;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RecurringCostMapper {
    public RecurringCost toRecurringCost(RecurringCostEntity entity){
        return RecurringCost.builder()
                .name(entity.getName())
                .cost(entity.getCost())
                .build();
    }

    public Set<RecurringCost> toRecurringCosts(Set<RecurringCostEntity> entities){
        return entities.stream().map(this::toRecurringCost).collect(Collectors.toSet());
    }

    public RecurringCostEntity toRecurringCostEntity(RecurringCost pojo){
        return RecurringCostEntity.builder()
                .name(pojo.getName())
                .cost(pojo.getCost())
                .build();
    }

    public Set<RecurringCostEntity> toRecurringCostEntities(Set<RecurringCost> pojos){
        return pojos.stream().map(this::toRecurringCostEntity).collect(Collectors.toSet());
    }
}
