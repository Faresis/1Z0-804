package ua.dp.mign.locale.format;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

class FormatNumber {
    public static void main(String[] args) {
        long tenMillion = 10_000_000L;
        Locale locale = Locale.getDefault();
        NumberFormat localFormat = NumberFormat.getInstance(locale);
        String localizedTenMillion = localFormat.format(tenMillion);
        System.out.printf("Ten million in %s locale is: %s%n", locale.getDisplayName(), localizedTenMillion);

        try {
            Number parsedNum = localFormat.parse(localizedTenMillion);
            if(parsedNum.longValue() == tenMillion) {
                System.out.println("Localized string successfully parsed.");
            }
        }
        catch (ParseException pe) {
            System.err.printf("Can't parse number for the %s locale.%n", locale);
        }
    }
}
