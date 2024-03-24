package be.aewyn.kakeify.entry;

import be.aewyn.kakeify.month.MonthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryDao extends JpaRepository<EntryEntity, Long> {
    List<EntryEntity> findAllByMonth(MonthEntity month);
}
