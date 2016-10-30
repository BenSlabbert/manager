package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.Person;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by benjamin on 2016/10/23.
 */
@Repository
public class PersonRepositoryImpl implements PersonRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    Person person;
    
    @Override
    public List<Person> getAll() {
        Query q = entityManager.createQuery("select p from Person p");
        List<Person> person = q.getResultList();
        return person;
    }
    
    @Override
    public Person getPersonById(Integer id) {
        Person p = entityManager.find(Person.class, id);
        return p;
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
    @Transactional(readOnly = false)
    public Integer save(Person p) {
        entityManager.persist(p);
        return p.getId();
    }
    
    @Override
    @Transactional(readOnly = false)
    public void delete(Person p) {
        entityManager.remove(entityManager.find(Person.class, p.getId()));
    }
}
