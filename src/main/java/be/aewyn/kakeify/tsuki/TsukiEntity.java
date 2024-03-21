package be.aewyn.kakeify.tsuki;

import be.aewyn.kakeify.entry.EntryEntity;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class TsukiEntity {
    @Id
    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToMany(mappedBy = "id")
    private Set<EntryEntity> entryEntities;
}
