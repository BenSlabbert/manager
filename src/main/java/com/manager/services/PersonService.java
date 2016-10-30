package com.manager.services;

import com.manager.entity.Person;
import com.manager.repository.PersonRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.manager.config.ApplicationConfig;


/**
 * Created by benjamin on 2016/10/23.
 */
public class PersonService {

    public PersonService() {
    }

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfig.class, ApplicationConfig.class);

        Person person = context.getBean(Person.class);

        PersonRepository personImpl = context.getBean(PersonRepository.class);

        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }

        person = personImpl.getPersonById(1);

        System.out.println(person.toString());


    }
}
