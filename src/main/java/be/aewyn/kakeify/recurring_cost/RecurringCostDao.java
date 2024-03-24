package be.aewyn.kakeify.recurring_cost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecurringCostDao extends JpaRepository<RecurringCostEntity, Long> {
}
