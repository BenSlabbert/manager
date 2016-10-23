package manager;

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
        
    }
}
