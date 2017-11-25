/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
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
import util.DateUtil;

/**
 *
 * @author Student
 */
@Named(value = "visitBean")
@SessionScoped
public class VisitBean implements Serializable {

    private List<Visit> visits;

    public void add(Visit v) {
        visits.add(v);
    }

    public VisitBean() {

    }

    @PostConstruct
    public void init() {
        visits = new ArrayList();
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public List<Visit> getTodayVisits(int doctorId) {
        List<Visit> list = new ArrayList();
        for (Visit visit : visits) {
            if (doctorId == visit.getDoctor().getId()
                    && DateUtil.isToday(visit.getDate())) {
                list.add(visit);
            }
        }
        return list;
    }

    public Patient getPatient(int doctorId, LocalTime time) {

        for (Visit visit : visits) {

            if (doctorId == visit.getDoctor().getId()) {
                Date date = visit.getDate();
                if (DateUtil.isToday(visit.getDate())) {
                    LocalTime time2 = DateUtil.toLocalTime(date);
                    if (time.getHour()==time2.getHour() && time.getMinute()==time2.getMinute()) {
                        return visit.getPatient();
                    }
                }
            }
        }
        return null;
    }

    

}
