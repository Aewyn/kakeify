package be.aewyn.kakeify.month;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MonthRepositoryImpl implements MonthRepository {
    private final MonthDao monthDao;
    private final MonthMapper monthMapper;
    @Override
    public Optional<Month> findByDate(LocalDate date) {
        return monthDao.findById(date).map(monthMapper::toMonth);
    }

    @Override
    public List<Month> findAll() {
        return monthMapper.toMonths(monthDao.findAll());
    }

    @Override
    public Month save(Month month) {
        return monthMapper.toMonth(monthDao.save(monthMapper.toMonthEntity(month)));
    }

    @Override
    public void delete(Month month){
        monthDao.delete(monthMapper.toMonthEntity(month));
    }
}
