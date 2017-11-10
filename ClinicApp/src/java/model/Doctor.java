/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.EnumMap;
import java.util.HashMap;
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

    public Doctor(String name, String lastname, int id) {
        super(name, lastname, id);
        admissionHours = new EnumMap(DayOfWeek.class);
        for(DayOfWeek day : DayOfWeek.values())
        {
            admissionHours.put(day, new Interval(LocalTime.MIN, LocalTime.MIN));
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

    private Map<DayOfWeek,Interval> admissionHours;

    public Map<DayOfWeek, Interval> getAdmissionHours() {
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
        public String toString()
        {
            switch(this){
                case pediatrician : return rb.getString("pediatrician");
                case laryngologist : return rb.getString("laryngologist");
                case endocrinologist : return rb.getString("endocrinologist");
                case ophthalmologist : return rb.getString("ophthalmologist");
                case dentist : return rb.getString("dentist");
                default : return "";
            }
            
        }
        
    }

}
