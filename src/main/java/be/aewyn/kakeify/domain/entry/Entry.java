package be.aewyn.kakeify.domain.entry;

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
}
