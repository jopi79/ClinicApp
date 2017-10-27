/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

/**
 *
 * @author Student
 */
public class Patient extends Person {

    private Date birthDate;

    public Patient(String name, String lastname, int id) {
        super(name, lastname, id);
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getFormattedBirthDate()
    {
        LocalDate date = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return date;
    }

}
