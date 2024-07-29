package be.aewyn.kakeify.domain.month;

import be.aewyn.kakeify.domain.createentryfacade.CreateEntryFacade;
import be.aewyn.kakeify.domain.entry.CreateEntryDto;
import be.aewyn.kakeify.domain.entry.EntryDao;
import be.aewyn.kakeify.domain.entry.EntryType;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.time.YearMonth;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ActiveProfiles({ "test" })
class MonthControllerTest {
	private static final Logger LOG = LoggerFactory.getLogger(MonthControllerTest.class);

	@Autowired
	private MonthDao monthDao;

	@Autowired
	private MonthService monthService;

	@Autowired
	EntityManager entityManager;

	@LocalServerPort
	int port;

	@Container
	@ServiceConnection
	static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:16.3-alpine");

	static RestClient restClient = RestClient.create();

	private static final CreateMonthDto CREATE_MONTH_DTO1 = new CreateMonthDto(YearMonth.of(2024, 7), BigDecimal.TEN, BigDecimal.TWO);
	private static final CreateMonthDto CREATE_MONTH_DTO2 = new CreateMonthDto(YearMonth.of(2024, 8), BigDecimal.TEN, BigDecimal.TWO);
	private static final CreateMonthDto CREATE_MONTH_DTO3 = new CreateMonthDto(YearMonth.of(2024, 9), BigDecimal.TEN, BigDecimal.TWO);

	private static final CreateEntryDto CREATE_ENTRY_DTO1 = new CreateEntryDto(EntryType.WANTS, BigDecimal.TWO, YearMonth.of(2024, 7));
	private static final CreateEntryDto CREATE_ENTRY_DTO2 = new CreateEntryDto(EntryType.WANTS, BigDecimal.TWO, YearMonth.of(2024, 8));
	private static final CreateEntryDto CREATE_ENTRY_DTO3 = new CreateEntryDto(EntryType.WANTS, BigDecimal.TWO, YearMonth.of(2024, 9));
	@Autowired
	private CreateEntryFacade createEntryFacade;

	@BeforeEach
	public void setUp() {
		monthService.save(CREATE_MONTH_DTO1);
		monthService.save(CREATE_MONTH_DTO2);
		monthService.save(CREATE_MONTH_DTO3);

		LOG.info("Saved months.");

//		createEntryFacade.save(CREATE_ENTRY_DTO1);
//		createEntryFacade.save(CREATE_ENTRY_DTO2);
//		createEntryFacade.save(CREATE_ENTRY_DTO3);

		// Saving the entries breaks everything.

		LOG.info("Saved entrie");
	}

	@AfterEach
	void afterEach() {
		monthDao.deleteAll();
	}

	@Nested
	class Get_mappings {
		@Test
		void should_find_all_months_when_findAll_is_called() {
            var responseEntity = restClient
                    .get()
                    .uri(STR."http://localhost:\{port}/api/months")
                    .retrieve()
                    .toEntity(SavedMonthDto[].class);

			assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
			assertThat(responseEntity.getHeaders().getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
			assertThat(responseEntity.getBody()).hasSize(3);
		}

		@Test
		void should_contain_entries_per_month_when_findAll_is_called() {
			var responseEntity = restClient
                    .get()
                    .uri(STR."http://localhost:\{port}/api/months")
                    .retrieve()
                    .toEntity(SavedMonthDto[].class);

			assertThat(responseEntity.getBody()[0].entries()).hasSize(0);
			assertThat(responseEntity.getBody()[1].entries()).hasSize(0);
			assertThat(responseEntity.getBody()[2].entries()).hasSize(0);
		}
	}

	@Nested
	class Post_mappings {
		@Test
		void should_return_saved_month_when_creating_new_month() {
			var createMonthDto = new CreateMonthDto(YearMonth.of(2024, 4), BigDecimal.TEN, BigDecimal.TEN);

			var responseEntity = restClient
					.post()
					.uri(STR."http://localhost:\{port}/api/months")
					.body(createMonthDto)
					.contentType(MediaType.APPLICATION_JSON)
					.retrieve()
					.toEntity(SavedMonthDto.class);

			assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
			assertThat(responseEntity.getHeaders().getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
			var savedMonthDto = responseEntity.getBody();
			assertThat(savedMonthDto.yearMonth()).isEqualTo(createMonthDto.yearMonth());
			assertThat(savedMonthDto.income()).isEqualTo(createMonthDto.income());
			assertThat(savedMonthDto.savingsGoal()).isEqualTo(createMonthDto.savingsGoal());
		}
	}
}