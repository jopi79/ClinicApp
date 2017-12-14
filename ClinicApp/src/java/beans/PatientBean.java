/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import model.Doctor;
import model.Patient;

/**
 *
 * @author Student
 */
@Named(value = "patientBean")
@SessionScoped
public class PatientBean implements Serializable{

    private List<Patient> patients;

    private int selectedId;
    private Patient selected;

    public int getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
        this.selected = find(selectedId);
    }
    
     Patient find(int id)
    {
        for(Patient d : patients)
        {
            if(d!=null && d.getId()==id) return d;
        }
        return new Patient("Brak danych","Brak danych");//!!!
    }

    public Patient getSelected() {
        return selected;
    }
    
    public List<Patient> getPatients() {
        return patients;
    }

    public void add(Patient d)
    {
        patients.add(d);
    }
    
    
    /**
     * Creates a new instance of DoctorBean
     */
    public PatientBean() {
        
    }
    
    @PostConstruct
    public void init()
    {
        patients = new ArrayList();
        Patient d = new Patient("Ewa","Ezmont",1);
        LocalDate localDate = LocalDate.of(1956, Month.DECEMBER, 12);
        d.setBirthDate(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        patients.add(d);
        d = new Patient("Franciszek","Fijałkowski",2);
        localDate = LocalDate.of(1990, Month.AUGUST, 12);
        d.setBirthDate(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        patients.add(d);
        d = new Patient("Giedymin","Graczyk",3);
        localDate = LocalDate.of(1966, Month.FEBRUARY, 12);
        d.setBirthDate(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        patients.add(d);
        d = new Patient("Halina","Hańska",4);
        localDate = LocalDate.of(2012, Month.SEPTEMBER, 12);
        d.setBirthDate(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        patients.add(d);
    }
}
