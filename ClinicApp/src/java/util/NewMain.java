/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import model.AdmissionHoursEntry;
import model.Doctor;
import model.Patient;
import model.Person;
import model.Specialization;
import model.Visit;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Student
 */
public class NewMain {

    private static void createDB() {
        AnnotationConfiguration config = new AnnotationConfiguration();
        config.addAnnotatedClass(Person.class);
        config.addAnnotatedClass(Doctor.class);
        config.addAnnotatedClass(Patient.class);
        config.addAnnotatedClass(AdmissionHoursEntry.class);
//        config.addAnnotatedClass(Specialization.class);
        config.addAnnotatedClass(Visit.class);
        config.configure("hibernate.cfg.xml");
        new SchemaExport(config).create(true, true);
    }

    private static void dateTest() {
        LocalTime time = LocalTime.of(8, 0);
        System.out.println(time);
        Date date = DateUtil.getTodayDayWithGivenHour("18:15");
        System.out.println(date);
        
    }
    
    private static void string()
    {
        
        System.out.println(StringUtil.stripDiacritics("julianbąk"));
        System.out.println(StringUtil.stripDiacritics("czesławceliński"));
        System.out.println(StringUtil.stripDiacritics("wieńczysławwańkowszczak"));
        
        System.out.println(StringUtil.removePolishChars("julianbąk"));
        System.out.println(StringUtil.removePolishChars("czesławceliński"));
        System.out.println(StringUtil.removePolishChars("wieńczysławwańkowszczak"));
    }
    
    public static void main(String[] args) {
        //createDB();
        //dateTest();
        string();
    }

}
