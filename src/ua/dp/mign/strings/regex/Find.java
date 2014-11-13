package ua.dp.mign.strings.regex;

import java.util.regex.*;

class Find {
    public static void main(String[] args) {
        String str = "Danny Doo, Flat no 502, Big Apartment, Wide Road, Near Huge Milestone, Hugo-city 56010, Ph: 9876543210, Email: danny@myworld.com. Maggi Myer, Post bag no 52, Big bank dudle@org.dp.ua. post office, Big bank city 56000, ph: 9876501234, Email: maggi07@myuniverse.com.";

        Pattern pattern = Pattern.compile("\\w+@(\\w+\\.)*\\w+");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
