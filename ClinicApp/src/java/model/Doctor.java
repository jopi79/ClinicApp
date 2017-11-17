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
import util.Interval;

/**
 *
 * @author Student
 */
public class Doctor extends Person {

    private Specialization specialization;
    private boolean active;
    private List<AdmissionHoursEntry> admissionHours;

    public Doctor(String name, String lastname, int id) {
        super(name, lastname, id);
        admissionHours = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        Date date =  calendar.getTime();
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

    public enum Specialization {
        pediatrician,
        laryngologist,
        endocrinologist,
        ophthalmologist,
        dentist;
        private final static ResourceBundle rb = ResourceBundle.getBundle("messages.specializations");

        @Override
        public String toString() {
            switch (this) {
                case pediatrician:
                    return rb.getString("pediatrician");
                case laryngologist:
                    return rb.getString("laryngologist");
                case endocrinologist:
                    return rb.getString("endocrinologist");
                case ophthalmologist:
                    return rb.getString("ophthalmologist");
                case dentist:
                    return rb.getString("dentist");
                default:
                    return "";
            }

        }

    }

}
