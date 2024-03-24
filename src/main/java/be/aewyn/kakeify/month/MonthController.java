package be.aewyn.kakeify.month;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/month")
@RequiredArgsConstructor
public class MonthController {
    private final MonthService monthService;
    @GetMapping("/all")
    public List<Month> findAll(){
        return monthService.findAll();
    }

    @GetMapping("/{year}/{month}")
    public Month findByDate(@PathVariable int year, @PathVariable int month){
        LocalDate date = LocalDate.of(year, month, 1);
        return monthService.findByDate(date).orElse(null);
    }

    @PutMapping("/")
    public Month save(@RequestBody Month month){
        return monthService.save(month);
    }

    @DeleteMapping
    public void delete(@RequestBody Month month){
        monthService.delete(month);
    }
}
