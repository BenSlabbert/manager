import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ApplicationConfig;
import entity.Person;
import org.springframework.util.DigestUtils;
import services.PersonService;
import sun.security.provider.SHA;


/**
 * Created by benjamin on 2016/10/30.
 */
public class Manager {
    
    
    
    public static void main(String[] args) {
        
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfig.class, ApplicationConfig.class);
        
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        
        PersonService service = context.getBean(PersonService.class);
        
        List<Person> personList = service.getAll();
        
        for (Person p : personList) {
            System.out.println(p.toString());
        }
        
        Person person = service.getPersonById(personList.get(0).getId());
        System.out.println(person.toString());
        
        service.delete(person);

        service.savePerson(new Person("h", "h"));
        service.savePerson(new Person("h", "h"));
        service.savePerson(new Person("h", "h"));
        service.savePerson(new Person("h", "h"));

    }
    
    
}
