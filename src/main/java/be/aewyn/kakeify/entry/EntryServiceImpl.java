package be.aewyn.kakeify.entry;

import be.aewyn.kakeify.month.Month;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntryServiceImpl implements EntryService{
    private final EntryRepository entryRepository;

    @Override
    public Entry save(Entry entry){
        return entryRepository.save(entry);
    }

    @Override
    public List<Entry> findAllByMonth(Month month) {
        return entryRepository.findByMonth(month);
    }
}
