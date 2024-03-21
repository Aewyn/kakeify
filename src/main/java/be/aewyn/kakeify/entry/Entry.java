package be.aewyn.kakeify.entry;

import be.aewyn.kakeify.month.Month;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;

@Builder
@Data
@Value
public class Entry {
    EntryType entryType;
    BigDecimal amount;
    Month month;
}
