package be.aewyn.kakeify.entry;

import be.aewyn.kakeify.month.Month;
import be.aewyn.kakeify.month.MonthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EntryRepositoryImpl implements EntryRepository{
    private final EntryDao entryDao;
    private final EntryMapper entryMapper;
    private final MonthMapper monthMapper;

    @Override
    public Entry save(Entry entry){
        return entryMapper.toEntry(entryDao.save(entryMapper.toEntryEntity(entry)));
    }

    @Override
    public void delete(Entry entry){
        entryDao.delete(entryMapper.toEntryEntity(entry));
    }

    @Override
    public List<Entry> findByMonth(Month month) {
        return entryMapper.toEntries(entryDao.findAllByMonth(monthMapper.toMonthEntity(month)));
    }
}
