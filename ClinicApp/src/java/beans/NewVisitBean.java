/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.Size;
import model.Doctor;
import model.Patient;
import model.Visit;

/**
 *
 * @author Student
 */
@Named(value = "newVisitBean")
@RequestScoped
public class NewVisitBean {

    private int patientId, doctorId;
//    private Patient patient;
//    private Doctor doctor;
    private Date date;

    
    
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

//    public Patient getPatient() {
//        return patient;
//    }
//
//    public void setPatient(Patient patient) {
//        this.patient = patient;
//    }
//
//    public Doctor getDoctor() {
//        return doctor;
//    }
//
//    public void setDoctor(Doctor doctor) {
//        this.doctor = doctor;
//    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    @Inject
    PatientBean patientBean;
    public List<Patient> getPatients()
    {
        return patientBean.getPatients();
    }
    
    @Inject
    DoctorBean doctorBean;
    public List<Doctor> getDoctors()
    {
        return doctorBean.getDoctors();
    }
    
    @Inject
    VisitBean visitBean;
    
    public String save()
    {
        Patient patient = patientBean.find(patientId);
        Doctor doctor = doctorBean.find(doctorId);
        Visit visit = new Visit(doctor,patient,date);
        visitBean.add(visit);
        return null;
    }
    
    
    public NewVisitBean() {
    }
    
}
