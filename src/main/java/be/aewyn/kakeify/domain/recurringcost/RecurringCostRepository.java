package be.aewyn.kakeify.domain.recurringcost;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RecurringCostRepository {
    private final RecurringCostDao recurringCostDao;

    public Set<RecurringCost> findAll(){
        return recurringCostDao.findAll().stream().map(RecurringCostConverter::toRecurringCost).collect(Collectors.toSet());
    }

    public RecurringCost save(RecurringCost recurringCost) {
        return RecurringCostConverter.toRecurringCost(recurringCostDao.save(RecurringCostConverter.toRecurringCostEntity(recurringCost)));
    }

    public void delete(RecurringCost recurringCost) {
        recurringCostDao.delete(RecurringCostConverter.toRecurringCostEntity(recurringCost));
    }
}
