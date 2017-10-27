/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Student
 */
public class Person {
    private String name, lastname;
    private String login, password;
    private int id;

    public Person(String name, String lastname, int id) {
        this.name = name;
        this.lastname = lastname;
        this.id = id;
    }

    public int getId() {
        return id;
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
