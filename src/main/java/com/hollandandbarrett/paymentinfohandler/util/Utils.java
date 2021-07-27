package com.hollandandbarrett.paymentinfohandler.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public class Utils {

    public static Month getPreviousMonth(LocalDate localDate) {
        return Month.from(localDate.minusMonths(1));
    }

    public static Year getYearOfPreviousMonth(LocalDate localDate) {
        return Year.from(localDate.minusMonths(1));
    }

    public static String formatForAmountDisplay(Double amount) {
        return String.format("%.2f", amount);
    }

}
