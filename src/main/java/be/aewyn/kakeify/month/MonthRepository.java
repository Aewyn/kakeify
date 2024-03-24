package be.aewyn.kakeify.month;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MonthRepository{
    Optional<Month> findByDate(LocalDate date);

    List<Month> findAll();

    Month save(Month monthEntity);

    void delete(Month month);
}
