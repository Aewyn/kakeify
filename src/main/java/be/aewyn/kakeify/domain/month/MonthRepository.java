package be.aewyn.kakeify.domain.month;

import be.aewyn.kakeify.exceptions.MonthAlreadyExistsException;
import be.aewyn.kakeify.exceptions.MonthNotFoundException;
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
        var monthEntity = monthDao.findByDate(LocalDate.of(month.getDate().getYear(), month.getDate().getMonth(), 1));
        if (monthEntity.isPresent()) {
            throw new MonthAlreadyExistsException(STR."Month already exists for \{month.getDate()}");
        }
        return MonthConverter.toMonth(monthDao.save(MonthConverter.toMonthEntity(month)));
    }

    public Month findByYearMonth(YearMonth yearMonth) {
        LocalDate date = LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), 1);
        var monthEntity = monthDao.findByDate(date);
        if (monthEntity.isPresent()) {
            return MonthConverter.toMonth(monthEntity.get());
        } else {
            throw new MonthNotFoundException(STR."Month not found for \{yearMonth}");
        }
    }

    public Month findById(Long id) {
        var monthEntity = monthDao.findById(id);
        if (monthEntity.isPresent()) {
            return MonthConverter.toMonth(monthEntity.get());
        } else {
            throw new MonthNotFoundException(STR."Month not found with id \{id}");
        }
    }
}
