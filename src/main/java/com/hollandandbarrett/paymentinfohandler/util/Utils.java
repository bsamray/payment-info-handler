package com.hollandandbarrett.paymentinfohandler.util;

import java.time.*;

public class Utils {

    public static Month getPreviousMonth(LocalDate localDate) {
        return Month.from(localDate.minusMonths(1));
    }

    public static Year getYearOfPreviousMonth(LocalDate localDate) {
        return Year.from(localDate.minusMonths(1));
    }

}
