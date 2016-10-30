package repositories;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.manager.config.ApplicationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.manager.entity.Person;
import com.manager.repository.PersonRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by benjamin on 2016/10/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@Transactional
public class PersonRepositoryImplTest {
    
    @Autowired
    private PersonRepository repository;
    
    @Test
    public void testGetAccounts() throws Exception {
        Person person = repository.getPersonById(1);
        assertThat(person.getId(), is(1));
    }
}
