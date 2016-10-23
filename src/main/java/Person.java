import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by benjamin on 2016/10/23.
 */
@Entity
@Table(appliesTo = "person")
public class Person {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;
}
