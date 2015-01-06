package ua.dp.mign.locale.format;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class CustomDatePatterns {
    public static void main(String[] args) {
        String[] dateFormats = {
            "dd-MM-yyyy", /* d is day in month, M is month
                             y is year */
            "d '('E')' MMM, YYYY", /* E is name of the day
                                      in week,
                                      Y  is year */
            "w'th week of' YYYY", /* w is the week of year */
            "EEEE, dd'th' MMMM, YYYY" /* E is day name in the week */
        };
        Date today = new Date();
        System.out.printf("Default format for the date is %s.%n",
                          DateFormat.getInstance().format(today));
        for(String dateFormat : dateFormats) {
            System.out.printf("Date in pattern \"%s\" is %s %n",
                              dateFormat,
                              new SimpleDateFormat(dateFormat).format(today));
        }
    }
}
