package be.aewyn.kakeify.domain.month;

import be.aewyn.kakeify.domain.entry.EntryEntity;
import be.aewyn.kakeify.domain.recurringcost.RecurringCostEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "months")
public class MonthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "income")
    private BigDecimal income;

    @Column(name = "savings_goal")
    private BigDecimal savingsGoal;

    @Column(name = "date")
    private LocalDate date;

    @OneToMany(mappedBy = "id")
    private Set<RecurringCostEntity> recurringCosts;

    @OneToMany(mappedBy = "month")
    private List<EntryEntity> entryEntities;
}