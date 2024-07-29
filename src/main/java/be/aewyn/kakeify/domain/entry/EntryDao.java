package be.aewyn.kakeify.domain.entry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryDao extends JpaRepository<EntryEntity, Long> {
}
