package be.aewyn.kakeify.domain.entry;

import be.aewyn.kakeify.domain.month.Month;
import be.aewyn.kakeify.domain.month.MonthConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EntryRepository {
    private final EntryDao entryDao;

    public Entry save(Entry entry) {
        return EntryConverter.toEntry(entryDao.save(EntryConverter.toEntryEntity(entry)));
    }

    public void delete(Entry entry) {
        entryDao.delete(EntryConverter.toEntryEntity(entry));
    }

    public List<Entry> findByMonth(Month month) {
        return EntryConverter.toEntries(entryDao.findAllByMonth(MonthConverter.toMonthEntity(month)));
    }
}
