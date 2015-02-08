package ua.dp.mign.mock2;

import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;

class DateFormat_04 {
    /*
     * In the current example formatting string contains
     * three placeholders whereas only one argument
     * is passed to the format method. This is achieved
     * by using '<' symbol which indicates that argument
     * from the previous placeholder should be used.
     */
    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        Calendar calendar = Calendar.getInstance(Locale.US);
        calendar.set(2012, Calendar.FEBRUARY, 1);
        formatter.format("%tY/%<tB/%<td", calendar);
        System.out.println(formatter);
    }
}
