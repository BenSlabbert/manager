package services;

import config.ApplicationConfig;
import entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by benjamin on 2016/10/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@Transactional
public class PersonServiceTest {

    @Autowired
    PersonService service;

    @Autowired
    Person person;

    @Test
    public void test(){
        Person p = new Person();
        p.setName("test");
        p.setSurname("test");
        Integer i  = service.savePerson(p);
    }
}
