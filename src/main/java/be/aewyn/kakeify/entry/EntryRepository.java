package be.aewyn.kakeify.entry;

import be.aewyn.kakeify.month.Month;

import java.util.List;

public interface EntryRepository{
    Entry save(Entry entry);
    void delete(Entry entry);
    List<Entry> findByMonth(Month month);
}
