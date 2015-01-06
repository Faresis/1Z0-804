package ua.dp.mign.locale.format;

import java.util.Date;
import java.text.DateFormat;

class DateStyleFormats {
    public static void main(String[] args) {
        Date now = new Date();
        int[] dateStyleFormats = { DateFormat.SHORT, DateFormat.MEDIUM, DateFormat.LONG, DateFormat.FULL, DateFormat.DEFAULT };
        System.out.println("Today's date in different styles are:");

        for(int style : dateStyleFormats) {
            DateFormat dateFormat = DateFormat.getDateInstance(style);
            System.out.println(dateFormat.format(now));
        }
    }
}
