package be.aewyn.kakeify.month;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MonthService {
    private final MonthRepository monthRepository;

    public Optional<Month> findByDate(LocalDate date) {
        return monthRepository.findByDate(date);
    }

    public List<Month> findAll(){
        return monthRepository.findAll();
    }
}
