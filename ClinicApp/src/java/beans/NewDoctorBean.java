/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.Size;
import model.Doctor;

/**
 *
 * @author Student
 */
@Named(value = "newDoctorBean")
@RequestScoped
public class NewDoctorBean {
    @Size(min=1,message="{name_not_empty}")
    private String name;
    @Size(min=1,message="{lastname_not_empty}")
    private String lastname;
    private Doctor.Specialization specialization;
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

    public Doctor.Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Doctor.Specialization specialization) {
        this.specialization = specialization;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    @Inject
    DoctorBean doctorsBean;
    
    public String save()
    {
        Doctor d = new Doctor(name, lastname,5);
        d.setActive(active);
        d.setSpecialization(specialization);
        doctorsBean.add(d);
        return "doctors";
    }

    public Doctor.Specialization[] getSpecializations()
    {
        return Doctor.Specialization.values();
    }
    /**
     * Creates a new instance of NewDoctorBean
     */
    public NewDoctorBean() {
    }
    
}
