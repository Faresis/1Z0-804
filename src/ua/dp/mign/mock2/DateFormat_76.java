package ua.dp.mign.mock2;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

class DateFormat_76 {
    /*
     * In this example since Calendar.MONTH count starts
     * from 0 value of 12 passed to set method will cause
     * overflow and year number will be increased by 1
     */
    public static void main(String[] args) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG,
                                                   Locale.US);
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2012);
        c.set(Calendar.MONTH, 12);
        c.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(df.format(c.getTime()));
    }
}
