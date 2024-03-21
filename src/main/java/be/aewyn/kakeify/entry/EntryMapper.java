package be.aewyn.kakeify.entry;

import be.aewyn.kakeify.month.MonthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EntryMapper {
    private final MonthMapper monthMapper;

    public Entry toEntry(EntryEntity entity){
        return Entry.builder()
                .entryType(entity.getEntryType())
                .amount(entity.getAmount())
                .month(monthMapper.toMonth(entity.getMonth()))
                .build();
    }

    public List<Entry> toEntries(List<EntryEntity> entities){
        return entities.stream().map(this::toEntry).toList();
    }

    public EntryEntity toEntryEntity(Entry pojo){
        return EntryEntity.builder()
                .entryType(pojo.getEntryType())
                .amount(pojo.getAmount())
                .month(monthMapper.toMonthEntity(pojo.getMonth()))
                .build();
    }

    public List<EntryEntity> toEntryEntities(List<Entry> pojos){
        return pojos.stream().map(this::toEntryEntity).toList();
    }
}
