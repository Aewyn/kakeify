package be.aewyn.kakeify.domain.month;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
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

    public Month save(createMonthDto createMonthDto) {
        Month month = Month.builder()
                .date(createMonthDto.localDate())
                .savingsGoal(createMonthDto.savingsGoal())
                .recurringCosts(new HashSet<>())
                .entries(new ArrayList<>())
                .build();
        return monthRepository.save(month);
    }
}