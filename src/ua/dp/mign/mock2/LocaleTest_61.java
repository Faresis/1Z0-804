package ua.dp.mign.mock2;

import java.util.Locale;

class LocaleTest_61 {
    /*
     * Current example shows that Local object
     * can be constructed with any string values
     * even if such locale is not present in the
     * system
     */
    public static void main(String[] args) {
        Locale locale = new Locale("navi", "pandora");
        System.out.println(locale);
    }
}
