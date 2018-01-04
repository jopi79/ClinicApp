/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 *
 * @author Student
 */
public class StringUtil {

    public static final Pattern DIACRITICS_AND_FRIENDS
            = Pattern.compile("[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+");

    public static String stripDiacritics(String str) {
        str = Normalizer.normalize(str, Normalizer.Form.NFD);
        str = DIACRITICS_AND_FRIENDS.matcher(str).replaceAll("");
        return str;
    }
    public static String removePolishChars(String s)
    {
        return s.replaceAll("ł", "l").
                replaceAll("ą", "a").
                replaceAll("ę","e").
                replaceAll("ć","c").
                replaceAll("ń","n").
                replaceAll("ó","o").
                replaceAll("ś","s").
                replaceAll("ż","z").
                replaceAll("ź","z");
    }
}
