package ua.dp.mign.locale.format;

import java.util.Locale;
import java.text.NumberFormat;

class LocalizedCurrency {
    public static void main(String[] args) {
        long tenMillion = 10_000_000L;
        Locale[] locales = 
            { Locale.CANADA, Locale.FRANCE, Locale.GERMANY, Locale.TAIWAN };
        for(Locale locale : locales) {
            System.out.printf("Ten million in %s is %s.%n", locale.getDisplayName(), NumberFormat.getCurrencyInstance(locale).format(tenMillion));
        }
    }
}
