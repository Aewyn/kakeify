package be.aewyn.kakeify.recurring_cost;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RecurringCostServiceImpl implements RecurringCostService{
    private final RecurringCostRepository recurringCostRepository;

    @Override
    public Set<RecurringCost> findAll() {
        return recurringCostRepository.findAll();
    }

    @Override
    public RecurringCost save(RecurringCost recurringCost) {
        return recurringCostRepository.save(recurringCost);
    }

    @Override
    public void delete(RecurringCost recurringCost) {
        recurringCostRepository.delete(recurringCost);
    }
}
