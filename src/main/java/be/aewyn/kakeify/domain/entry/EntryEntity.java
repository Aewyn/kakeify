package be.aewyn.kakeify.domain.entry;

import be.aewyn.kakeify.domain.month.MonthEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Builder
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "entries")
public class EntryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entry_type")
    private EntryType entryType;

    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "month_id")
    private MonthEntity month;
}
