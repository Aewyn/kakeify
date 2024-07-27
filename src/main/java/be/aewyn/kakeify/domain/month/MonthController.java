package be.aewyn.kakeify.domain.month;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/month")
@RequiredArgsConstructor
public class MonthController {
    private final MonthService monthService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody createMonthDto createMonthDto) {
        var savedMonth = monthService.save(createMonthDto);
        var savedMonthDto = new savedMonthDto(savedMonth.date, savedMonth.savingsGoal, savedMonth.getRecurringCosts(), savedMonth.getEntries());
        return new ResponseEntity<>(savedMonth, HttpStatus.CREATED);
    }
}