import entity.Person;
import services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ApplicationConfig;


/**
 * Created by benjamin on 2016/10/30.
 */
public class Manager {

    @Autowired
    private static PersonService service;
    
    public static void main(String[] args) {
        
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfig.class, ApplicationConfig.class);
        
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }

        Person person = service.getPersonById(1);

        System.out.println(person.getName());
        
    }


}
