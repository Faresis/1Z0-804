package ua.dp.mign.locale;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

class PrintResourceBundleControl extends ResourceBundle.Control {
    public List<Locale> getCandidateLocales(String baseName, Locale locale) {
        List<Locale> candidates = super.getCandidateLocales(baseName, locale);
        System.out.printf("Candidate locales for the base name %s and locale %s %n", baseName, locale.getDisplayName());
        for(Locale candidate : candidates) {
            System.out.println(candidate);
        }
        return candidates;
    }
}

class LocalizedHello {
    public static void main(String[] args) {
        ResourceBundle bundle = getBundle();
        System.out.println(bundle.getString("Greeting"));
    }

    private static ResourceBundle getBundle() {
        /*
         * System will first search for localized bundle for the
         * locale set programmatically.
         * If no matches it will continue to search with a default
         * locale.
         * And finally search for a pure bundle name will be performed. 
         */
        Locale currentLocale = new Locale("fr","CA");
        ResourceBundle res = ResourceBundle.getBundle("GreetingBundle", currentLocale, new PrintResourceBundleControl());
        String locale = res.getLocale().toString();
        if("".equals(locale)) {
            System.out.println("Loaded default property file: GreetingBundle."); 
        } else {
            System.out.printf("Loaded the resource bundle for the locale: GreetingBundle_%s%n", locale);
        }
        return res;
    }
} 
