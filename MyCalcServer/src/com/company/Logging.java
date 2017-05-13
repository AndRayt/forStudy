package com.company;
import java.util.*;

/**
 * Логирование
 * Created by Андрей on 23.04.2017.
 */
public class Logging {
    public static void write(String user, String text) {
        Calendar c = Calendar.getInstance();
        int year = c.get(c.YEAR);
        int month = c.get(c.MONTH)+1;
        int day = c.get(c.DAY_OF_MONTH);
        int hour = c.get(c.HOUR);
        int min = c.get(c.MINUTE);
        if (wrFile.countRecord("log.doc") < 10) {
            wrFile.update("log.doc",user + " | " + day + "." + month + "." + year + " " + "(" + hour + ":" + min + ")" + " : "+ text);
        } else {
            String newName = "logOld" + Integer.toString(day) + "d" + Integer.toString(month) + "m" + Integer.toString(year) + "y" + hour + "h" + min + "m" +".doc";
            System.out.println(newName);
            wrFile.rename("log.doc",newName);
        }
    }
}
