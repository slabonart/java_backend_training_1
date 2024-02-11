package pl.slabonart.java_backend_training.task_3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import pl.slabonart.java_backend_training.task_3.model.User;
import pl.slabonart.java_backend_training.task_3.repository.UserRepository;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    private static final User TEST_USER = User.builder()
            .firstName("Artur")
            .sureName("Slabon")
            .birthDate(new Date())
            .build();

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }

    @AfterEach
    public void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void shouldSaveUser() {

        userRepository.save(TEST_USER);

        List<User> users = (List<User>) userRepository.findAll();

        assertEquals(1, users.size());
        checkUserDetails(users.get(0));
    }

    private void checkUserDetails(User user) {
        assertNotNull(user.getId());
        assertEquals(TEST_USER.getFirstName(), user.getFirstName());
        assertEquals(TEST_USER.getSureName(), user.getSureName());
        assertEquals(TEST_USER.getBirthDate(), user.getBirthDate());

    }

}
