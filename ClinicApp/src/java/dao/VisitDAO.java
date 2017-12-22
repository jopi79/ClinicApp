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
import model.Visit;
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
public class VisitDAO extends DAO {

    public static List<Visit> getVisits() {
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            Criteria criteria = session.createCriteria(Visit.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            List<Visit> list = criteria.list();
            return list;
        } finally {
            session.close();
        }
    }
    public static void save(Visit d)
    {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
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
    

}
