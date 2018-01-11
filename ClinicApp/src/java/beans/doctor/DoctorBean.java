/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.doctor;

import beans.UserBean;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import model.Doctor;

/**
 *
 * @author Student
 */
@Named(value = "doctorBean")
@RequestScoped
public class DoctorBean {

    @Inject
    private UserBean userBean;
    private Doctor doctor;
    
    @PostConstruct
    public void init()
    {
        doctor = (Doctor) userBean.getPerson();
    }
    
    public DoctorBean() {
    }
    
}
