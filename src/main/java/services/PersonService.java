package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import entity.Person;
import repository.PersonRepository;


/**
 * Created by benjamin on 2016/10/23.
 */
@Service
@Transactional
public class PersonService {
    
    @Autowired
    private PersonRepository repository;
    
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Person getPersonById(Integer id) {
        return repository.getPersonById(id);
    }
    
    @Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
    public Integer savePerson(Person p) {
        return repository.save(p);
    }
    
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Person> getAll() {
        return repository.getAll();
    }
    
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Person> searchByFirstName(String name) {
        return repository.searchByFirstName(name);
    }
    
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Person> searchByLastName(String name) {
        return repository.searchByLastName(name);
    }
    
    @Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
    public void delete(Person p) {
        repository.delete(p);
    }
    
}
