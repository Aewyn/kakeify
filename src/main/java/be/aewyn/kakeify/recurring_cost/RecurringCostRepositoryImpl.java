package be.aewyn.kakeify.recurring_cost;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RecurringCostRepositoryImpl implements RecurringCostRepository{
    private final RecurringCostDao recurringCostDao;
    private final RecurringCostMapper recurringCostMapper;

    @Override
    public Set<RecurringCost> findAll(){
        return recurringCostDao.findAll().stream().map(recurringCostMapper::toRecurringCost).collect(Collectors.toSet());
    }

    @Override
    public RecurringCost save(RecurringCost recurringCost) {
        return recurringCostMapper.toRecurringCost(recurringCostDao.save(recurringCostMapper.toRecurringCostEntity(recurringCost)));
    }

    @Override
    public void delete(RecurringCost recurringCost) {
        recurringCostDao.delete(recurringCostMapper.toRecurringCostEntity(recurringCost));
    }
}
