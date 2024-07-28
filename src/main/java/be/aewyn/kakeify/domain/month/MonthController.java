package be.aewyn.kakeify.domain.month;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/months")
@RequiredArgsConstructor
public class MonthController {
    private final MonthService monthService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        var allMonths = monthService.findAll();
        var savedMonthDtoList = allMonths.stream().map(SavedMonthDto::createFromMonth).toList();
        ResponseEntity<List<SavedMonthDto>> listResponseEntity = new ResponseEntity<>(savedMonthDtoList, HttpStatus.OK);
        return new ResponseEntity<>(savedMonthDtoList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody CreateMonthDto createMonthDto) {
        var savedMonth = monthService.save(createMonthDto);
        var savedMonthDto = SavedMonthDto.createFromMonth(savedMonth);
        return new ResponseEntity<>(savedMonthDto, HttpStatus.CREATED);
    }
}