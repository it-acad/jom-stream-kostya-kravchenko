package jom.com.softserve.s6.task2;

import java.time.LocalDate;
import java.time.Period;

public class MyUtils {
    public static String getDateAfterToday(int years, int months, int days) {
        return LocalDate.now().plus(Period.of(years,months,days)).toString();
    }
}
