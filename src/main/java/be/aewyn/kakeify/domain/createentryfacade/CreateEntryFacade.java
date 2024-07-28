package be.aewyn.kakeify.domain.createentryfacade;

import be.aewyn.kakeify.domain.entry.CreateEntryDto;
import be.aewyn.kakeify.domain.entry.Entry;
import be.aewyn.kakeify.domain.entry.EntryService;
import be.aewyn.kakeify.domain.month.Month;
import be.aewyn.kakeify.domain.month.MonthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateEntryFacade {
    private final EntryService entryService;
    private final MonthService monthService;

    public Entry save(CreateEntryDto createEntryDto) {
        Month month = monthService.findByYearMonth(createEntryDto.yearMonth());
        Entry entry = Entry.builder()
                .entryType(createEntryDto.entryType())
                .amount(createEntryDto.amount())
                .month(month)
                .build();
        return entryService.save(entry);
    }
}
