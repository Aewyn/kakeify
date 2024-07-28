package be.aewyn.kakeify.domain.entry;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
}
