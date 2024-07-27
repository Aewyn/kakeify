package be.aewyn.kakeify.domain.month;

import java.math.BigDecimal;
import java.time.LocalDate;

public record createMonthDto(
        LocalDate localDate,
        BigDecimal savingsGoal
) {
}
