package security;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import config.ApplicationConfig;


/**
 * Created by benjamin on 2016/10/30.
 */
public class Encrypt {
    
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfig.class, ApplicationConfig.class);
        
        ShaPasswordEncoder encoder = context.getBean(ShaPasswordEncoder.class);
        
        String encoded = encoder.encodePassword("hello", "salt");
        
        System.out.println(encoded);
    }
}
