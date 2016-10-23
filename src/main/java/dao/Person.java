package dao;

import javax.persistence.*;


/**
 * Created by benjamin on 2016/10/23.
 */
@Entity
@Table(name = "person")
public class Person {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String name;
    
    @Column
    private String surname;
    
    public Person() {
    }
    
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
}
