package ua.dp.mign.strings.regex;

import java.util.regex.*;

class Replace {
    public static void main(String[] args) {
        String string = "Danny Doo, Flat no 502, Big Apartment, Wide Road, Near Huge Milestone, Hugo-city 56010, Ph: 9876543210, Email: danny@myworld.com. Maggi Myer, Post bag no 52, Big bank dudle@org.dp.ua. post office, Big bank city 56000, ph: 9876501234, Email: maggi07@myuniverse.com.";
        Pattern pattern = Pattern.compile("(\\w+)@(\\w+\\.)*(\\w+)(\\d+)*");
        Matcher matcher = pattern.matcher(string);

        System.out.println("Before replacement: " + string);

        String erased = matcher.replaceAll("EMAIL_ERASED");
        System.out.println();
        System.out.println("After replacement: " + erased);
        matcher.reset();

        String tripleMail = matcher.replaceAll("$0 - $0 - $0");
        System.out.println();
        System.out.println("Triple mail replacement: " + tripleMail);
        matcher.reset();

        String detailedMail = matcher.replaceAll("(Mailbox=$1, Domain=$3, SubDomain=$2)");
        System.out.println();
        System.out.println("Detailed mail replacement: " + detailedMail);
    }
}
