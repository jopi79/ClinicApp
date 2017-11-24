/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import model.AdmissionHoursEntry;
import model.Doctor;
import model.Patient;
import model.Visit;

/**
 *
 * @author Student
 */
@Named(value = "todaysVisits")
@SessionScoped
public class TodaysVisitsBean implements Serializable {

    private List<Entry> rows;
    private int doctorId;
    private Doctor doctor;
    private int patientId;

    @PostConstruct
    public void init() {
        rows = new ArrayList();
        LocalTime time = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(18, 0);
        while (time.isBefore(endTime)) {
            Entry row = new Entry(time);
            rows.add(row);
            time = time.plus(15, ChronoUnit.MINUTES);
        }
    }

    public List<Entry> getRows() {
        return rows;
    }

    public class Entry {

        private LocalTime time;
        private boolean available;
        private Patient patient;

        public Entry(LocalTime time) {
            this.time = time;
        }

        public LocalTime getTime() {
            return time;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        public Patient getPatient() {
            return patient;
        }

        public void setPatient(Patient patient) {
            this.patient = patient;
        }

    }

    public int getDoctorId() {
        return doctorId;
    }

    @Inject
    DoctorBean doctorBean;

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
        this.doctor = doctorBean.find(doctorId);
        if (doctor != null) {
            updateRows();
        }
    }

    public Doctor getDoctor() {
        return doctor;
    }

    private void updateRows() {
        if (doctor == null) {
            return;
        }
        
        //pobierz godziny pracy tego lekarza na dzisiejszy dnia
        LocalDate today = LocalDate.now();
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        List<AdmissionHoursEntry> list = doctor.getAdmissionHours();
        Date from = null, to = null;
        for (AdmissionHoursEntry adm : list) {
            if (dayOfWeek == adm.getDayOfWeek()) {
                from = adm.getFrom();
                to = adm.getTo();
                break;
            }
        }
        LocalTime fromTime = LocalDateTime.ofInstant(from.toInstant(), ZoneId.systemDefault()).toLocalTime();
        LocalTime toTime = LocalDateTime.ofInstant(to.toInstant(), ZoneId.systemDefault()).toLocalTime();

        //pobierz dzisiejszych pacjentów tego lekarza (już umówione wizyty)
        List<Visit> myVisits = visitBean.getTodayVisits(doctorId);
        
        //wpisz w tabelkę dostępność
        for (Entry entry : rows) {
            LocalTime time = entry.getTime();
            if ((time.isAfter(fromTime) || time.equals(fromTime))
                    && (time.isBefore(toTime) || time.equals(toTime))) {
                entry.setAvailable(true);
            } else {
                entry.setAvailable(false);
            }
            Patient patient = VisitBean.getPatient(myVisits, time);
//            entry.setPatient(patient);
            entry.setPatient(new Patient("OOOO","Q "+myVisits.size(),78));
        }
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }



    @Inject
    private PatientBean patientBean;
    @Inject
    private VisitBean visitBean;

    public String addVisit() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String timeString = params.get("time");
        LocalTime time = LocalTime.parse(timeString);
        Patient patient = patientBean.find(patientId);
        LocalDate today = LocalDate.now();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, time.getHour());
        cal.set(Calendar.MINUTE, time.getMinute());
        cal.set(Calendar.DAY_OF_MONTH, today.getDayOfMonth());
        cal.set(Calendar.MONTH, today.getMonthValue());
        cal.set(Calendar.YEAR, today.getYear());
        Date date = cal.getTime();
        Date d = cal.getTime();
        Visit visit = new Visit(doctor, patient, date);
        visitBean.add(visit);
        return "visits";
    }

    public TodaysVisitsBean() {
    }

}
