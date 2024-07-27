package be.aewyn.kakeify.domain.month;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MonthRepository {
    private final MonthDao monthDao;

    public Optional<Month> findByDate(LocalDate date) {
        return monthDao.findById(date).map(MonthConverter::toMonth);
    }

    public List<Month> findAll() {
        return MonthConverter.toMonths(monthDao.findAll());
    }

    public Month save(Month month) {
        return MonthConverter.toMonth(monthDao.save(MonthConverter.toMonthEntity(month)));
    }

    public void delete(Month month){
        monthDao.delete(MonthConverter.toMonthEntity(month));
    }
}
