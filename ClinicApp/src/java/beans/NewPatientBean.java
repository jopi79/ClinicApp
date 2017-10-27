/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.time.LocalDate;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.Size;
import model.Doctor;
import model.Patient;

/**
 *
 * @author Student
 */
@Named(value = "newPatientBean")
@RequestScoped
public class NewPatientBean {
    @Size(min=1,message="{name_not_empty}")
    private String name;
    @Size(min=1,message="{lastname_not_empty}")
    private String lastname;

    private Date birthDate;
    
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    
    @Inject
    PatientBean patientBean;
    
    public String save()
    {
        Patient d = new Patient(name, lastname,5);
        d.setBirthDate(birthDate);
        patientBean.add(d);
        
        return "patients";
    }

    public NewPatientBean() {
    }
    
}
