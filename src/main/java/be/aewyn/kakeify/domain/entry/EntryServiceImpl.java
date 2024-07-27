package be.aewyn.kakeify.domain.entry;

import be.aewyn.kakeify.domain.month.Month;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public final class EntryServiceImpl {
    private final EntryRepository entryRepository;

    public Entry save(Entry entry){
        return entryRepository.save(entry);
    }

    public List<Entry> findAllByMonth(Month month) {
        return entryRepository.findByMonth(month);
    }
}
