package be.aewyn.kakeify.domain.month;

import be.aewyn.kakeify.domain.entry.EntryEntity;
import be.aewyn.kakeify.domain.recurringcost.RecurringCostEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @Column(name = "savings_goal")
    private BigDecimal savingsGoal;

    @OneToMany(mappedBy = "id")
    private Set<RecurringCostEntity> recurringCosts;

    @OneToMany(mappedBy = "id")
    private List<EntryEntity> entryEntities;

    @Column(name = "date")
    private Date date;

}
