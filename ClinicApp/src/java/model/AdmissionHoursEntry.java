/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author jopi79
 */
@Entity
@Table( name = "AdmissionHours" )
public class AdmissionHoursEntry {

    @Id
//    @GeneratedValue(generator = "increment")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AdmissionHours_SEQ")

@SequenceGenerator(name = "AdmissionHours_SEQ", sequenceName = "AdmissionHours_SEQ")
    private int id;

    private DayOfWeek dayOfWeek;
    private Date from, to;

    @ManyToOne
    private Doctor doctor;

    public AdmissionHoursEntry(DayOfWeek dayOfWeek, Date from, Date to) {
        this.dayOfWeek = dayOfWeek;
        this.from = from;
        this.to = to;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public String getDisplayDayOfWeek() {
        return dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault());
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
