package ua.dp.mign.strings.regex;

import java.util.regex.*;

class Find {
    public static void main(String[] args) {
        String str = "Danny Doo, Flat no 502, Big Apartment, Wide Road, Near Huge Milestone, Hugo-city 56010, Ph: 9876543210, Email: danny@myworld.com. Maggi Myer, Post bag no 52, Big bank dudle@org.dp.ua. post office, Big bank city 56000, ph: 9876501234, Email: maggi07@myuniverse.com.";

        Pattern pattern = Pattern.compile("(\\w+)@(\\w+\\.)*(\\w+)(\\d+)*");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()) {
            // matches whole pattern
            System.out.println("matcher.group(): " + matcher.group());

            // matches whole pattern
            System.out.println("matcher.group(0): " + matcher.group(0));

            // matches first group. Email prefix.
            System.out.println("matcher.group(1): " + matcher.group(1));

            // matches second group. Email corp domain.
            System.out.println("matcher.group(2): " + matcher.group(2));

            // matches third group. Email high level domain.
            System.out.println("matcher.group(3): " + matcher.group(3));

            // matches last group. For all examples it will be empty. Null is returned.
            System.out.println("matcher.group(4): " + matcher.group(4));
        }
    }
}
