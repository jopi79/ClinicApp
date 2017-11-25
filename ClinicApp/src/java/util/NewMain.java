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

/**
 *
 * @author Student
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(today.getMonthValue());
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 8);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.DAY_OF_MONTH, today.getDayOfMonth());
        cal.set(Calendar.MONTH, today.getMonthValue()-1);
        cal.set(Calendar.YEAR, today.getYear());
        Date date = cal.getTime();
        System.out.println(date);
        LocalTime time = LocalTime.of(8, 0);
        LocalTime time2 = DateUtil.toLocalTime(date);
        System.out.println(time2);
        System.out.println(time.equals(time2));
        System.out.println(time.getHour()==time2.getHour() && time.getMinute()==time2.getMinute());
    }
    
}
