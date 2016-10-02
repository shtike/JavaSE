package com.urise.webapp.Util;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by Admin on 23.09.16.
 */
public class DateUtil {

    public static final LocalDate NOW = LocalDate.of(300, 1, 1);

    public static LocalDate of(int year, Month month) {
        return LocalDate.of(year, month, 1);
    }


}
