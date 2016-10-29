package manager;

import java.util.List;

import dao.Person;
import dao.PersonImpl;


/**
 * Created by benjamin on 2016/10/23.
 */
public class Manager {
    
    
    public Manager() {
    }
    
    public static void main(String[] args) {
        
        Person person = new Person();
        
        PersonImpl personImpl = new PersonImpl();
        
        person = personImpl.getPersonById(1);
        
        System.out.println(person.getId() + " " + person.getName() + " " + person.getSurname());
        
        List<Person> personList = personImpl.searchByFirstName("ben");
        
        for (Person p : personList) {
            System.out.printf("name : %s%n", p.getName());
        }

        personList = personImpl.searchByLastName("slab");

        for (Person p : personList) {
            System.out.printf("surname : %s%n", p.getSurname());
        }

        person = personList.get(2);
        personImpl.delete(person);

    }
}
