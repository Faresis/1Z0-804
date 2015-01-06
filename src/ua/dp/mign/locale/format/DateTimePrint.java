package ua.dp.mign.locale.format;

import java.util.Locale;
import java.util.Date;
import java.text.DateFormat;

class DateTimePrint {
    public static void main(String[] args) {
        Date today = new Date();
        Locale[] locales = { Locale.FRANCE, Locale.GERMANY, Locale.CANADA, Locale.ITALY };
        System.out.printf("%5s \t %10s \t %10s \t %10s %n",
                          "Locale", "Date", "Time", "Date with Time");
        
        for(Locale locale : locales) {
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
            DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.SHORT, locale);
            DateFormat dateTimeFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.FULL, locale);
            System.out.printf("%5s \t %10s \t %10s \t %20s %n", locale,
                              dateFormat.format(today),
                              timeFormat.format(today),
                              dateTimeFormat.format(today));
        }
    }
}
