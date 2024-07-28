package be.aewyn.kakeify.domain.month;

import be.aewyn.kakeify.domain.entry.EntryEntity;
import be.aewyn.kakeify.domain.recurringcost.RecurringCostEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hibernate.annotations.CascadeType.PERSIST;

@Entity
@Builder
@Getter
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

    @OneToMany(mappedBy = "id")
    private Set<RecurringCostEntity> recurringCosts = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "month")
    @Cascade(PERSIST)
    private List<EntryEntity> entryEntities = new ArrayList<>();

    @Column(name = "date")
    private LocalDate date;
}
