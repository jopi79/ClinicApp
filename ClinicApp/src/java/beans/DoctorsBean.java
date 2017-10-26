/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import model.Doctor;

/**
 *
 * @author Student
 */
@Named(value = "doctorsBean")
@SessionScoped
public class DoctorsBean implements Serializable{

    private List<Doctor> doctors;

    private int selectedId;
    private Doctor selected;

    public int getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
        this.selected = find(selectedId);
    }
    
    private Doctor find(int id)
    {
        for(Doctor d : doctors)
        {
            if(d!=null && d.getId()==id) return d;
        }
        return new Doctor("Brak danych","Brak danych",0);//!!!
    }

    public Doctor getSelected() {
        return selected;
    }
    
    public List<Doctor> getDoctors() {
        return doctors;
    }

    
    
    
    /**
     * Creates a new instance of DoctorBean
     */
    public DoctorsBean() {
        
    }
    
    @PostConstruct
    public void init()
    {
        doctors = new ArrayList();
        Doctor d = new Doctor("Adam","Adamiak",1);
        d.setSpecialization("pediatra");
        doctors.add(d);
        d = new Doctor("Bazyl","Bieńkowski",2);
        d.setSpecialization("laryngolog");
        doctors.add(d);
        d = new Doctor("Celestyn","Cierak",3);
        d.setSpecialization("lekarz rodzinny");
        doctors.add(d);
        d = new Doctor("Damian","Daniszczuk",4);
        d.setSpecialization("endokrynolog");
        doctors.add(d);
    }
}
