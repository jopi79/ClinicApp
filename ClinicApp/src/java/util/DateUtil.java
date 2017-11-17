/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author jopi79
 */
public class DateUtil {

    public static Date toDate(LocalTime lt) {
        Instant instant = lt.atDate(LocalDate.of(2000, 1, 1)).
                atZone(ZoneId.systemDefault()).toInstant();
        Date time = Date.from(instant);
        return time;
    }

    public static LocalTime toLocalTime(Date date) {
        return null;
    }
}
