import java.util.List;

/**
 * Created by benjamin on 2016/10/23.
 */
public interface PersonDAO {
    
    Person getPersonById(long id);
    
    List<Person> searchByFirstName(String name);

    List<Person> searchByLastName(String name);
}
