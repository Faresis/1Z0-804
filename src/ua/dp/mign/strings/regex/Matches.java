package ua.dp.mign.strings.regex;

import java.util.regex.*;

class Matches {
    public static void main(String[] args) {
        String string = "dudle@test.dp.ua";
        String string2 = "dudle@test.dp.ua 4";
        String strPattern = "(\\w+)@(\\w+\\.)*(\\w+)";
        Pattern pattern = Pattern.compile(strPattern);
        Matcher matcher = pattern.matcher(string);
        Matcher matcher2 = pattern.matcher(string2);

        System.out.println("First string: " + string);
        System.out.println("Second string: " + string2);
        System.out.println("Pattern: " + strPattern);

        // matches return true only when whole region matches
        System.out.println("First string matches: " + matcher.matches());
        System.out.println("Second string matches: " + matcher2.matches());

        // lookingAt return true when beginning of region matches
        System.out.println("First string lookingAt: " + matcher.lookingAt());
        System.out.println("Second string lookingAt: " + matcher2.lookingAt());
    }
}
