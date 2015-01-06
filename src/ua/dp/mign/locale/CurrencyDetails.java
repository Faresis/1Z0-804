package ua.dp.mign.locale;

import java.util.Locale;
import java.util.Currency;

class CurrencyDetails {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        Currency currency = Currency.getInstance(locale);
        System.out.printf("The currency code for locale %s is %s.%n" +
                          "The currency symbol is %s.%n" +
                          "The currency name is %s.%n",
                          locale, currency.getCurrencyCode(),
                          currency.getSymbol(),
                          currency.getDisplayName());
    }
}
