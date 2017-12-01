/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ResourceBundle;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author jopi79
 */
@Entity
public enum Specialization {
    pediatrician(1),
    laryngologist(2),
    endocrinologist(3),
    ophthalmologist(4),
    dentist(5);

    @Id
    private int id;
    
    private Specialization(int id)
    {
        this.id = id;
    }


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
