/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import util.DateUtil;

/**
 *
 * @author jopi79
 */
@Entity
public class Doctor extends Person {

    @Enumerated(EnumType.STRING)
    private Specialization specialization;
    private boolean active;
    @OneToMany(mappedBy="doctor", fetch=FetchType.EAGER)
    private List<AdmissionHoursEntry> admissionHours;

    public Doctor(String name, String lastname) {
        super(name, lastname);
        admissionHours = new ArrayList();
        Date date =  DateUtil.getZeroZeroTime();
        for (DayOfWeek day : DayOfWeek.values()) {
            admissionHours.add(new AdmissionHoursEntry(day, date, date));
        }
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<AdmissionHoursEntry> getAdmissionHours() {
        return admissionHours;
    }
    
    public void setAdmissionHour(DayOfWeek day, LocalTime from, LocalTime to)
    {
        AdmissionHoursEntry entry = admissionHours.get(day.ordinal());
        entry.setFrom(DateUtil.toDate(from));
        entry.setTo(DateUtil.toDate(to));
    }

    public Doctor() {
    }

    

}
