/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import model.Doctor;
import util.Interval;

/**
 *
 * @author Student
 */
@Named(value = "admissionHoursBean")
@SessionScoped
public class AdmissionHoursBean implements Serializable{

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
        Map<DayOfWeek, Interval> ah = doctor.getAdmissionHours();
        admissionHours = convert(ah);
    }

    public Doctor getDoctor() {
        return doctor;
    }

    private List<Entry> admissionHours;

    public class Entry {

        private DayOfWeek dayOfWeek;
        private Date from, to;

        public Entry(DayOfWeek dayOfWeek, Date from, Date to) {
            this.dayOfWeek = dayOfWeek;
            this.from = from;
            this.to = to;
        }

        public DayOfWeek getDayOfWeek() {
            return dayOfWeek;
        }

        public Date getFrom() {
            return from;
        }

        public Date getTo() {
            return to;
        }

        public void setDayOfWeek(DayOfWeek dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
        }

        public void setFrom(Date from) {
            this.from = from;
        }

        public void setTo(Date to) {
            this.to = to;
        }

    }

    public List<Entry> getAdmissionHours() {
        return admissionHours;
    }

    private List<Entry> convert(Map<DayOfWeek, Interval> map) {
        List<Entry> list = new ArrayList();
        for (DayOfWeek day : map.keySet()) {
            LocalTime lt = map.get(day).getFrom();
            Instant instant = lt.atDate(LocalDate.of(2000, 1, 1)).
                    atZone(ZoneId.systemDefault()).toInstant();
            Date from = Date.from(instant);
            lt = map.get(day).getTo();
            instant = lt.atDate(LocalDate.of(2000, 1, 1)).
                    atZone(ZoneId.systemDefault()).toInstant();
            Date to = Date.from(instant);
            Entry entry = new Entry(day,from,to);
            list.add(entry);
        }
        return list;
    }

    public String save()
    {
        Map<DayOfWeek, Interval> ah = doctor.getAdmissionHours();
        for(Entry entry : admissionHours)
        {
            LocalTime from = LocalDateTime.ofInstant(entry.from.toInstant(),
                    ZoneId.systemDefault()).toLocalTime();
            LocalTime to = LocalDateTime.ofInstant(entry.to.toInstant(),
                    ZoneId.systemDefault()).toLocalTime();
            ah.put(entry.dayOfWeek, new Interval(from, to));
        }
        return null;
    }
    
    public AdmissionHoursBean() {
    }

}
