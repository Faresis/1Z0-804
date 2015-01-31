package ua.dp.mign.mock1;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Regex_59 {
    /*
     * In this example third word will not be printed
     * because there is no non-digit symbol which
     * matches \\D at the end of OCPJP7
     */
    public static void main(String[] args) {
        String str = "OCPJP 2013 OCPJP7";

        Pattern pattern = Pattern.compile("\\b\\w+\\D\\b");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
