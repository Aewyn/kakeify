package be.aewyn.kakeify.domain.entry;

import be.aewyn.kakeify.domain.month.MonthConverter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class EntryConverter {

    public static Entry toEntry(EntryEntity entryEntity) {
        return Entry.builder()
                .entryType(entryEntity.getEntryType())
                .amount(entryEntity.getAmount())
                .month(MonthConverter.toMonth(entryEntity.getMonth()))
                .build();
    }

    public static EntryEntity toEntryEntity(Entry entry) {
        return EntryEntity.builder()
                .entryType(entry.getEntryType())
                .amount(entry.getAmount())
                .month(MonthConverter.toMonthEntity(entry.getMonth()))
                .build();
    }

    public static List<Entry> toEntries(List<EntryEntity> entryEntities) {
        return entryEntities.stream().map(EntryConverter::toEntry).toList();
    }

    public static List<EntryEntity> toEntryEntities(List<Entry> entries) {
        return entries.stream().map(EntryConverter::toEntryEntity).toList();
    }
}
