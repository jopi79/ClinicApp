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

/**
 *
 * @author jopi79
 */
public class AdmissionHoursEntry {

    private DayOfWeek dayOfWeek;
    private Date from, to;

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
