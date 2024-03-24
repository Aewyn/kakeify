package be.aewyn.kakeify.month;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MonthServiceImpl implements MonthService{
    private final MonthRepository monthRepository;

    @Override
    public Optional<Month> findByDate(LocalDate date) {
        return monthRepository.findByDate(date);
    }

    @Override
    public List<Month> findAll(){
        return monthRepository.findAll();
    }

    @Override
    public Month save(Month month){
        return monthRepository.save(month);
    }

    @Override
    public void delete(Month month){
        monthRepository.delete(month);
    }
}
