package br.com.jonss.homeboy.config;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDateTime;
import java.util.Calendar;

@Converter(autoApply = true)
public class LocaldateTimeConverter implements AttributeConverter<LocalDateTime, Calendar> {

    @Override
    public Calendar convertToDatabaseColumn(LocalDateTime localDateTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, localDateTime.getDayOfMonth());
        calendar.set(Calendar.MONTH, localDateTime.getMonthValue() - 1);
        calendar.set(Calendar.YEAR, localDateTime.getYear());
        calendar.set(Calendar.MINUTE, localDateTime.getMinute());
        calendar.set(Calendar.HOUR, localDateTime.getHour());
        calendar.set(Calendar.SECOND, localDateTime.getSecond());
        return calendar;
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Calendar calendar) {
        return LocalDateTime.of(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND));
    }
}
