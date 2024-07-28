package be.aewyn.kakeify.domain.month;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MonthRepository {
    private final MonthDao monthDao;

    public List<Month> findAll() {
        return MonthConverter.toMonths(monthDao.findAll());
    }

    public Month save(Month month) {
        return MonthConverter.toMonth(monthDao.save(MonthConverter.toMonthEntity(month)));
    }

    public Month findByYearMonth(YearMonth yearMonth) {
        LocalDate date = LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), 1);
        return MonthConverter.toMonth(monthDao.findByDate(date));
    }
}
