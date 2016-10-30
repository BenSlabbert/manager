package services;

import entity.Person;
import repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


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

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Integer savePerson(Person p) {
        return repository.save(p);
    }
    
}
