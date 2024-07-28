package be.aewyn.kakeify.domain.month;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.time.YearMonth;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles({"test"})
@Transactional(propagation = Propagation.REQUIRES_NEW)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MonthControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:16.3-alpine");


    @Test
    void should_find_all_months() {
        var responseEntity = restTemplate.getForEntity("/api/months", SavedMonthDto[].class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getHeaders().getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
        assertThat(responseEntity.getBody()).hasSize(4);
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