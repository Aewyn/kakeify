package be.aewyn.kakeify.month;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface MonthDao extends JpaRepository<MonthEntity, Date> {
}