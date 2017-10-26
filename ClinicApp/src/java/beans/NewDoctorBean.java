/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import model.Doctor;

/**
 *
 * @author Student
 */
@Named(value = "newDoctorBean")
@RequestScoped
public class NewDoctorBean {
    private String name,lastname;
    private String specialization;
    private boolean active;

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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    @Inject
    DoctorsBean doctorsBean;
    
    public String save()
    {
        Doctor d = new Doctor(name, lastname,5);
        d.setActive(active);
        d.setSpecialization(specialization);
        doctorsBean.add(d);
        return "doctors";
    }

    /**
     * Creates a new instance of NewDoctorBean
     */
    public NewDoctorBean() {
    }
    
}
