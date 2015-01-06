package ua.dp.mign.locale.format;

import java.util.Date;
import java.text.SimpleDateFormat;

class PatternFormatDate {
    public static void main(String[] args) {
        String pattern = "dd-MM-yy";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        System.out.println(formatter.format(new Date()));
    }
}
