package com.manager.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.manager.entity.Person;
import org.springframework.stereotype.Repository;


/**
 * Created by benjamin on 2016/10/23.
 */
@Repository
public class PersonRepository implements PersonDAO {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Person getPersonById(Integer id) {
        Person person = entityManager.find(Person.class, id);
        return person;
    }
    
    @Override
    public List<Person> searchByFirstName(String searchFirstName) {
        
        Query q = entityManager.createQuery("select p from Person p where p.name = :name");
        q.setParameter("name", searchFirstName);
        List<Person> person = q.getResultList();
        return person;
    }
    
    @Override
    public List<Person> searchByLastName(String searchLastName) {
        Query q = entityManager.createQuery("select p from Person p where p.surname = :name");
        q.setParameter("name", searchLastName);
        List<Person> person = q.getResultList();
        return person;
    }
    
    @Override
    public Integer save(Person p) {
        entityManager.persist(p);
        return p.getId();
    }
    
    @Override
    public void delete(Person p) {
        entityManager.remove(entityManager.find(Person.class, p.getId()));
    }
}
