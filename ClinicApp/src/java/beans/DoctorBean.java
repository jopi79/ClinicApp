/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.DoctorDAO;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import model.Doctor;
import model.Specialization;

/**
 *
 * @author jopi79
 */
@Named(value = "doctorBean")
@SessionScoped
public class DoctorBean implements Serializable{

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
    
     Doctor find(int id)
    {
        for(Doctor d : doctors)
        {
            if(d!=null && d.getId()==id) return d;
        }
        return new Doctor("Brak danych","Brak danych");//!!!
    }

    public Doctor getSelected() {
        return selected;
    }
    
    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void save(Doctor d)
    {
        DoctorDAO.save(d);
        doctors.add(d);
    }
    
    
    /**
     * Creates a new instance of DoctorBean
     */
    public DoctorBean() {
        
    }
    
    @PostConstruct
    public void init()
    {
        doctors = DoctorDAO.getDoctors();
        /*
        doctors = new ArrayList();
        Doctor d = new Doctor("Adam","Adamiak",1);
        d.setSpecialization(Specialization.pediatrician);
        d.setAdmissionHour(DayOfWeek.MONDAY, LocalTime.of(8, 0), LocalTime.of(12,0));
        doctors.add(d);
        d = new Doctor("Bazyl","Bieńkowski",2);
        d.setSpecialization(Specialization.endocrinologist);
        d.setAdmissionHour(DayOfWeek.TUESDAY, LocalTime.of(10, 0), LocalTime.of(12,0));
        d.setAdmissionHour(DayOfWeek.FRIDAY, LocalTime.of(8, 0), LocalTime.of(12,0));
        d.setAdmissionHour(DayOfWeek.SATURDAY, LocalTime.of(8, 0), LocalTime.of(12,0));
        d.setAdmissionHour(DayOfWeek.THURSDAY, LocalTime.of(8, 0), LocalTime.of(12,0));
        doctors.add(d);
        d = new Doctor("Celestyn","Cierak",3);
        d.setSpecialization(Specialization.laryngologist);
        d.setAdmissionHour(DayOfWeek.WEDNESDAY, LocalTime.of(12, 0), LocalTime.of(15,0));
        doctors.add(d);
        d = new Doctor("Damian","Daniszczuk",4);
        d.setSpecialization(Specialization.ophthalmologist);
        d.setAdmissionHour(DayOfWeek.THURSDAY, LocalTime.of(14, 0), LocalTime.of(18,0));
        doctors.add(d);*/
    }
}
