package jom.com.softserve.s6.task1;

import java.time.LocalDate;
import java.time.Month;

public class MyUtils {

    public static boolean isLeapYear(int year) {
//    return (year & 3) == 0 && ((year % 100) != 0 || (year % 400) == 0);
        return LocalDate.of(year, Month.JANUARY, 1).isLeapYear();
    }

}
