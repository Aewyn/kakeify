package be.aewyn.kakeify.month;

import be.aewyn.kakeify.entry.EntryEntity;
import be.aewyn.kakeify.recurring_cost.RecurringCostEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
public class MonthEntity {
    @Id
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "savings_goal")
    private BigDecimal savingsGoal;

    @OneToMany(mappedBy = "id")
    private Set<RecurringCostEntity> recurringCosts;

    @OneToMany(mappedBy = "id")
    private Set<EntryEntity> entryEntities;


}
