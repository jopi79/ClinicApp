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
import model.Visit;

/**
 *
 * @author Student
 */
@Named(value = "visitBean")
@SessionScoped
public class VisitBean implements Serializable{

    private List<Visit> visits;
//
//    private int selectedId;
//    private Patient selected;
//
//    public int getSelectedId() {
//        return selectedId;
//    }
//
//    public void setSelectedId(int selectedId) {
//        this.selectedId = selectedId;
//        this.selected = find(selectedId);
//    }
//    
//    private Patient find(int id)
//    {
//        for(Patient d : patients)
//        {
//            if(d!=null && d.getId()==id) return d;
//        }
//        return new Patient("Brak danych","Brak danych",0);//!!!
//    }
//
//    public Patient getSelected() {
//        return selected;
//    }
//    
//    public List<Patient> getPatients() {
//        return patients;
//    }
//
    public void add(Visit v)
    {
        visits.add(v);
    }

    public VisitBean() {
        
    }
    
    @PostConstruct
    public void init()
    {
        visits = new ArrayList();        
    }
}
