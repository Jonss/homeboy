package br.com.jonss.homeboy.util;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

    public static LocalDateTime nowInSaoPaulo() {
        ZoneId of = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime instant = ZonedDateTime.ofInstant(Instant.now(), of);
        return instant.toLocalDateTime();
    }

    public static String dateToString(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static String timeToString(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public static LocalDateTime januaryAtMidnight() {
        return LocalDateTime.of(2000, Month.JANUARY, 1, 0, 0, 0);
    }

    public static boolean hadNotLeave(LocalDateTime localDateTime) {
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        return Integer.valueOf(hour).equals(0) && Integer.valueOf(minute).equals(0);
    }
}
