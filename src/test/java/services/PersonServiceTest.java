package services;

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
    public void testGetPersonById() throws Exception {
        person = service.getPersonById(9);
        Person p = new Person("dad", "slab");
        p.setId(9);
        Assert.assertEquals(p.toString(), person.toString());
    }
    
    @Test
    public void testGetPersonByFirstName() throws Exception {
        List<Person> person = service.searchByFirstName("ben");
        for (Person p : person) {
            Assert.assertEquals("ben", p.getName());
        }
    }
    
    @Test
    public void testGetPersonByLastName() throws Exception {
        List<Person> person = service.searchByLastName("slab");
        for (Person p : person) {
            Assert.assertEquals("slab", p.getSurname());
        }
    }
    
    @Test
    public void testSavePerson() throws Exception {
        
        Person p = new Person("anne", "slab");
        Integer newId = service.savePerson(p);
        p.setId(newId);
        person = service.getPersonById(newId);
        Assert.assertEquals(p.toString(), person.toString());
    }
    
    @Test
    public void testDeletePerson() throws Exception {
        person = service.getPersonById(10);
        service.delete(person);
        Person p = service.getPersonById(10);
        
        Assert.assertTrue(p == null);
    }
}
