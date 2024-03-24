package be.aewyn.kakeify.recurring_cost;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RecurringCostService {
    Set<RecurringCost> findAll();
    RecurringCost save(RecurringCost recurringCost);
    void delete(RecurringCost recurringCost);
}
