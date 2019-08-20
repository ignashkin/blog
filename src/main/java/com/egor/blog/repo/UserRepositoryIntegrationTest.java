package com.egor.blog.repo;

import com.egor.blog.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        User alex = new User();
        entityManager.persist(alex);
        entityManager.flush();

        // when
        User found = userRepository.findByUsername(alex.getUsername());

        // then
        assertThat(found.getUsername())
                .isEqualTo(alex.getUsername());
    }

}
