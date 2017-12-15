/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.DoctorDAO;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import model.AdmissionHoursEntry;
import model.Doctor;
import util.DateUtil;

/**
 *
 * @author jopi79
 */
@Named(value = "admissionHoursBean")
@SessionScoped
public class AdmissionHoursBean implements Serializable {

    private int doctorId;
    private Doctor doctor;

    public int getDoctorId() {
        return doctorId;
    }

    @Inject
    DoctorBean doctorBean;

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
        doctor = doctorBean.find(doctorId);
        admissionHours = doctor.getAdmissionHours();
    }

    public Doctor getDoctor() {
        return doctor;
    }

    private List<AdmissionHoursEntry> admissionHours;

    public List<AdmissionHoursEntry> getAdmissionHours() {
        return admissionHours;
    }

    public AdmissionHoursBean() {
    }

    public String save() {
        for (AdmissionHoursEntry e : admissionHours) {
            DoctorDAO.update(e);
        }
        return "doctors";
    }
}
