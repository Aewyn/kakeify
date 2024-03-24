package be.aewyn.kakeify.recurring_cost;

import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RecurringCostRepository {
    Set<RecurringCost> findAll();
    RecurringCost save(RecurringCost recurringCost);
    void delete(RecurringCost recurringCost);
}
