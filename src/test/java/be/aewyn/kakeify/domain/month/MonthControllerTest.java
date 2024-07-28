package be.aewyn.kakeify.domain.month;

import be.aewyn.kakeify.domain.createentryfacade.CreateEntryFacade;
import be.aewyn.kakeify.domain.entry.CreateEntryDto;
import be.aewyn.kakeify.domain.entry.EntryDao;
import be.aewyn.kakeify.domain.entry.EntryType;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.time.YearMonth;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ActiveProfiles({"test"})
class MonthControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MonthDao monthDao;

    @Autowired
    private MonthService monthService;

    @Autowired
    private CreateEntryFacade createEntryFacade;

    @Autowired
    private EntryDao entryDao;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:16.3-alpine");


    @BeforeEach
    void beforeEach() {
        CreateMonthDto createMonthDto1 = new CreateMonthDto(YearMonth.of(2024, 7), BigDecimal.TEN, BigDecimal.TWO);
        CreateMonthDto createMonthDto2 = new CreateMonthDto(YearMonth.of(2024, 8), BigDecimal.TEN, BigDecimal.TWO);
        CreateMonthDto createMonthDto3 = new CreateMonthDto(YearMonth.of(2024, 9), BigDecimal.TEN, BigDecimal.TWO);
        monthService.save(createMonthDto1);
        monthService.save(createMonthDto2);
        monthService.save(createMonthDto3);

        CreateEntryDto createEntryDto1 = new CreateEntryDto(EntryType.NEEDS, BigDecimal.TEN, YearMonth.of(2024, 7));
        CreateEntryDto createEntryDto2 = new CreateEntryDto(EntryType.UNEXPECTED, BigDecimal.TEN, YearMonth.of(2024, 7));
        CreateEntryDto createEntryDto3 = new CreateEntryDto(EntryType.WANTS, BigDecimal.TEN, YearMonth.of(2024, 8));
        CreateEntryDto createEntryDto4 = new CreateEntryDto(EntryType.CULTURE, BigDecimal.TEN, YearMonth.of(2024, 8));
        CreateEntryDto createEntryDto5 = new CreateEntryDto(EntryType.WANTS, BigDecimal.TEN, YearMonth.of(2024, 9));
        CreateEntryDto createEntryDto6 = new CreateEntryDto(EntryType.UNEXPECTED, BigDecimal.TEN, YearMonth.of(2024, 9));

        createEntryFacade.save(createEntryDto1);
        createEntryFacade.save(createEntryDto2);
        createEntryFacade.save(createEntryDto3);
        createEntryFacade.save(createEntryDto4);
        createEntryFacade.save(createEntryDto5);
        createEntryFacade.save(createEntryDto6);
    }

    @AfterEach
    void afterEach() {
        entryDao.deleteAll();
        monthDao.deleteAll();
    }

    @Test
    void should_find_all_months() {
        var responseEntity = restTemplate.getForEntity("/api/months", SavedMonthDto[].class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getHeaders().getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
        assertThat(responseEntity.getBody()).hasSize(3);
    }

    @Test
    void should_return_saved_month_when_creating_new_month() {
        var createMonthDto = new CreateMonthDto(YearMonth.of(2024, 4), BigDecimal.TEN, BigDecimal.TEN);
        var responseEntity = restTemplate.postForEntity("/api/months", createMonthDto, SavedMonthDto.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(responseEntity.getHeaders().getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
        var savedMonthDto = responseEntity.getBody();
        assertThat(savedMonthDto.yearMonth()).isEqualTo(createMonthDto.yearMonth());
        assertThat(savedMonthDto.income()).isEqualTo(createMonthDto.income());
        assertThat(savedMonthDto.savingsGoal()).isEqualTo(createMonthDto.savingsGoal());
    }
}