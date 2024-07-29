package be.aewyn.kakeify.domain.recurringcost;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RecurringCostService {
    private final RecurringCostRepository recurringCostRepository;

    public Set<RecurringCost> findAll() {
        return recurringCostRepository.findAll();
    }

    public RecurringCost save(RecurringCost recurringCost) {
        return recurringCostRepository.save(recurringCost);
    }

    public void delete(RecurringCost recurringCost) {
        recurringCostRepository.delete(recurringCost);
    }
}
