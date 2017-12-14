/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author jopi79
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="PERSON_TYPE",discriminatorType=DiscriminatorType.STRING)
public abstract class Person {
    private String name, lastname;
    private String login, password;
    @Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OSOBA_SEQ")
@SequenceGenerator(name = "OSOBA_SEQ", sequenceName = "OSOBA_SEQ_W_BAZIE")
//    @GeneratedValue(generator="increment")
//    @GenericGenerator(name="increment", strategy = "increment")
//    @GeneratedValue(generator = "autoincrement")  
// @GenericGenerator(name = "autoincrement", strategy = "identity")  
    private int id;

    public Person(String name, String lastname, int id) {
        this.name = name;
        this.lastname = lastname;
        this.id = id;
    }

    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person() {
    }


    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String toString()
    {
        return lastname+" "+name;
    }
}
