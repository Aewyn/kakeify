package be.aewyn.kakeify.month;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface MonthService {
    Optional<Month> findByDate(LocalDate date);
    List<Month> findAll();
    Month save(Month month);
    void delete(Month month);
}
