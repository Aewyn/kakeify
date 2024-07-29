package be.aewyn.kakeify.domain.month;

import java.math.BigDecimal;
import java.time.YearMonth;

public record CreateMonthDto(
        YearMonth yearMonth,
        BigDecimal income,
        BigDecimal savingsGoal
) {
}
