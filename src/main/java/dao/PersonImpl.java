package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


/**
 * Created by benjamin on 2016/10/23.
 */
public class PersonImpl implements PersonDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("myDb");
    
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
    public List<Person> searchByFirstName(String name) {
        return null;
    }
    
    @Override
    public List<Person> searchByLastName(String name) {
        return null;
    }
}
