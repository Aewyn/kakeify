package be.aewyn.kakeify.domain.month;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MonthService {
    private final MonthRepository monthRepository;

    public Month findById(Long id) {
        return monthRepository.findById(id);
    }

    public List<Month> findAll(){
        return monthRepository.findAll();
    }

    public Month save(CreateMonthDto createMonthDto) {
        Month month = Month.builder()
                .date(createMonthDto.yearMonth())
                .income(createMonthDto.income())
                .savingsGoal(createMonthDto.savingsGoal())
                .entries(new ArrayList<>())
                .recurringCosts(new HashSet<>())
                .build();
        return monthRepository.save(month);
    }

    public Month findByYearMonth(YearMonth yearMonth) {
        return monthRepository.findByYearMonth(yearMonth);
    }
}