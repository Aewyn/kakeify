package be.aewyn.kakeify.domain.month;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;


@Repository
public interface MonthDao extends JpaRepository<MonthEntity, Long> {
    Optional<MonthEntity> findByDate(LocalDate date);
}