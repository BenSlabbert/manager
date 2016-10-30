package repositories;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import config.ApplicationConfig;
import entity.Person;
import repository.PersonRepository;


/**
 * Created by benjamin on 2016/10/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@Transactional
public class PersonRepositoryImplTest {
    
    @Autowired
    private PersonRepository repository;
    
    @Autowired
    Person person;
    
    @Test
    public void testGetPersonById() throws Exception {
        person = repository.getPersonById(1);
        Person p = new Person("dad", "slab");
        p.setId(9);
        Assert.assertEquals(p.toString(), person.toString());
    }
    
    @Test
    public void testGetPersonByFirstName() throws Exception {
        List<Person> person = repository.searchByFirstName("ben");
        for (Person p : person) {
            Assert.assertEquals("ben", p.getName());
        }
    }
    
    @Test
    public void testGetPersonByLastName() throws Exception {
        List<Person> person = repository.searchByLastName("slab");
        for (Person p : person) {
            Assert.assertEquals("slab", p.getSurname());
        }
    }
    
    @Test
    public void testSavePerson() throws Exception {
        
        Person p = new Person("anne", "slab");
        Integer newId = repository.save(p);
        p.setId(newId);
        person = repository.getPersonById(newId);
        Assert.assertEquals(p.toString(), person.toString());
    }
    
    @Test
    public void testDeletePerson() throws Exception {
        person = repository.getPersonById(1);
        repository.delete(person);
        Person p = repository.getPersonById(1);
        
        Assert.assertTrue(p == null);
    }
}
