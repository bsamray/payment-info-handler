package com.hollandandbarrett.paymentinfohandler.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {

    @Test
    public void whenCurrentIsFirstMonth_shouldReturnPreviousYearMonth() {
        LocalDate localDate = LocalDate.of(2021, Month.JANUARY, 3);
        assertThat(Utils.getPreviousMonth(localDate)).isEqualTo(Month.DECEMBER);
        assertThat(Utils.getYearOfPreviousMonth(LocalDate.of(2021, Month.JANUARY, 3)))
                .isEqualTo(Year.of(2020));
    }

    @Test
    public void whenCurrentIs31stJuly_shouldReturn30June() {
        LocalDate localDate = LocalDate.of(2021, Month.JULY, 31);
        assertThat(Utils.getPreviousMonth(localDate)).isEqualTo(Month.JUNE);
        assertThat(Utils.getYearOfPreviousMonth(LocalDate.of(2021, Month.JANUARY, 3)))
                .isEqualTo(Year.of(2020));
    }

}
