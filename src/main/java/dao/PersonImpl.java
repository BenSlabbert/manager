package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 * Created by benjamin on 2016/10/23.
 */
public class PersonImpl implements PersonDAO {
    
    // TODO : replace EntityManagerFactory with a spring bean
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("myDb");
    
    @Override
    public Person getPersonById(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        em.getTransaction().commit();
        em.close();
        return person;
    }
    
    @Override
    public List<Person> searchByFirstName(String searchFirstName) {
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("select p from Person p where p.name = :name");
        q.setParameter("name", searchFirstName);
        List<Person> person = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return person;
    }
    
    @Override
    public List<Person> searchByLastName(String searchLastName) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("select p from Person p where p.surname = :name");
        q.setParameter("name", searchLastName);
        List<Person> person = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return person;
    }
    
    @Override
    public Integer save(Person p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        return p.getId();
    }
    
    @Override
    public void delete(Person p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Person.class, p.getId()));
        em.getTransaction().commit();
        em.close();
    }
}
