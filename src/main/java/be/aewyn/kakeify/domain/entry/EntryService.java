package be.aewyn.kakeify.domain.entry;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntryService {
    private final EntryRepository entryRepository;

    public Entry save(Entry entry){
        return entryRepository.save(entry);
    }
}
