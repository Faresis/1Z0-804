package ua.dp.mign.mock1;

import java.util.Formatter;
import java.util.Calendar;
import java.util.Locale;

class DateFormat_81 {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        Calendar calendar = Calendar.getInstance(Locale.US);
        calendar.set(2014, Calendar.FEBRUARY, 1);
        formatter.format("%tY/%tm/%td",
                         calendar, calendar, calendar);
        System.out.println(formatter);
    }
}
