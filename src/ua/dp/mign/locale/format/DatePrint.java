package ua.dp.mign.locale.format;

import java.util.Locale;
import java.util.Date;
import java.text.DateFormat;

class DatePrint {
    public static void main(String[] args) {
        Date today = new Date();
        Locale[] locales = { Locale.FRANCE, Locale.GERMANY, Locale.CANADA, Locale.ITALY };
        for(Locale locale : locales) {
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
            System.out.printf("Date in locale %s is: %s.%n", locale, dateFormat.format(today));
        }
    }
}
