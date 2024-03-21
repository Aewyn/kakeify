package be.aewyn.kakeify.entry;

import be.aewyn.kakeify.tsuki.TsukiEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class EntryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entry_type")
    private EntryType entryType;

    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "tsuki_id")
    private TsukiEntity tsuki;
}
