package be.aewyn.kakeify.domain.entry;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@ActiveProfiles({"test"})
@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class EntryDaoTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:16.3-alpine");
    //Using static here makes you use the same container between tests rather than firing up a new one each time.

    @Autowired
    EntryDao entryDao;

    @Nested
    class Container_tests {
        @Test
        void should_succeed_when_checking_if_container_is_created_and_running() {
            Assertions.assertThat(postgresContainer.isCreated()).isTrue();
            Assertions.assertThat(postgresContainer.isRunning()).isTrue();
        }
    }

    @Nested
    class EntryDao_tests {
        @Test
        void should_return_test_values_when_calling_FindAll() {
            var allEntries = entryDao.findAll();
            Assertions.assertThat(allEntries).isNotEmpty();
        }

        @Test
        void should_throw_exception_when_calling_findById_with_wrong_id() {

        }

        @Test
        void should_return_entity_when_calling_findById_with_correct_id() {
            var entry = entryDao.findById(1L);

        }
    }
}