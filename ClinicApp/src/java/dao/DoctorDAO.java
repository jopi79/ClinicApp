/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import model.AdmissionHoursEntry;
import model.Doctor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DateUtil;
import util.HibernateUtil;

/**
 *
 * @author jopi79
 */
public class DoctorDAO extends DAO {

    public static List<Doctor> getDoctors() {
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            Criteria criteria = session.createCriteria(Doctor.class);
            List<Doctor> list = criteria.list();
            return list;
        } finally {
            session.close();
        }
    }
    public static void save(Doctor d)
    {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<AdmissionHoursEntry> admissionHours = d.getAdmissionHours();
            for(AdmissionHoursEntry entry : admissionHours)
            {
                entry.setDoctor(d);
                Integer id = (Integer) session.save(entry);
                entry.setId(id);
            }
            Integer id = (Integer) session.save(d);
            d.setId(id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
    
    public static void update(AdmissionHoursEntry entry)
    {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(entry);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
}
