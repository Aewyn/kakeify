package be.aewyn.kakeify.domain.entry;

import be.aewyn.kakeify.domain.month.Month;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class Entry {
    EntryType entryType;
    BigDecimal amount;
    Month month;
}
