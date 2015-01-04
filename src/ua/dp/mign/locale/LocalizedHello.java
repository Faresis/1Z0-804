package ua.dp.mign.locale;

import java.util.Locale;
import java.util.ResourceBundle;

class LocalizedHello {
    public static void main(String[] args) {
        Locale currentLocale = Locale.getDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("GreetingBundle", currentLocale);
        System.out.println(bundle.getString("Greeting"));
    }
} 
