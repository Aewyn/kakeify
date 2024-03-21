package be.aewyn.kakeify.month;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MonthRepositoryImpl implements MonthRepository {
    private final MonthDao monthDao;
    private final MonthMapper monthMapper;
    @Override
    public Optional<Month> findByDate(LocalDate date) {
        return monthDao.findById(Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())).map(monthMapper::toMonth);
    }

    @Override
    public List<Month> findAll() {
        return monthMapper.toMonths(monthDao.findAll());
    }
}
