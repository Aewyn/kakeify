package be.aewyn.kakeify.domain.entry;

import java.math.BigDecimal;
import java.time.YearMonth;

public record CreateEntryDto(
        EntryType entryType,
        BigDecimal amount,
        YearMonth yearMonth
) {
}
