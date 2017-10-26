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
public class Doctor extends Person {

    private Specialization specialization;
    private boolean active;

    public Doctor(String name, String lastname, int id) {
        super(name, lastname, id);
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public enum Specialization {
        pediatrician,
        laryngologist,
        endocrinologist, 
        ophthalmologist,
        dentist
    }

}
