package repository;

import java.util.List;

import entity.Person;


/**
 * Created by benjamin on 2016/10/23.
 */
public interface PersonRepository {
    
    List<Person> getAll();

    Person getPersonById(Integer id);
    
    List<Person> searchByFirstName(String name);
    
    List<Person> searchByLastName(String name);
    
    Integer save(Person p);
    
    void delete(Person p);
}
