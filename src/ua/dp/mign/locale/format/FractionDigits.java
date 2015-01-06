package ua.dp.mign.locale.format;

import java.text.NumberFormat;
import java.text.ParseException;

class FractionDigits {
    public static void main(String[] args) throws ParseException {
        String[] strings = { "1.222", "0.12345F" };
        double[] doubles = { 1.222, 0.12345F };
        NumberFormat numberFormat = NumberFormat.getInstance();
        // such settings are only used for formatting and not for parsing
        numberFormat.setMaximumFractionDigits(2);
        System.out.println("Formatting numbers: ");
        for(double val : doubles) {
            System.out.println(numberFormat.format(val));
        }
        System.out.println("Parsing strings: ");
        for(String str : strings) {
            System.out.println(numberFormat.parse(str));
        }
    }
}
