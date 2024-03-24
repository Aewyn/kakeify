package be.aewyn.kakeify.entry;

import be.aewyn.kakeify.month.Month;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EntryService {
    Entry save(Entry entry);
    List<Entry> findAllByMonth(Month month);
}
