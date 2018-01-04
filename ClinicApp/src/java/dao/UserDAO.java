/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Doctor;
import model.Person;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import util.HibernateUtil;
import util.PasswordUtil;

/**
 *
 * @author Student
 */
public class UserDAO {

    public static Person getUser(String login, String password) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {

            Query query = session.createQuery("from Person p where p.login = :login ");
            query.setParameter("login", login);
            List list = query.list();
            if(!list.isEmpty()) 
            {
                Person person = (Person) list.get(0);
                if(PasswordUtil.checkPassword(password, person.getPassword()))
                {
                    return person;
                }
            }
            return null;
           
        } finally {
            session.close();
        }
    }
}
