package ua.dp.mign.strings;

class RegionMatches {
    public static void main(String[] args) {
        String str1 = "Hello, world!";
        String str2 = "world, hello";

        System.out.println(str1.substring(7, 12) + " equals " + str2.substring(0, 5) + " : " + str1.regionMatches(7, str2, 0, 5));
        System.out.println(str1.substring(0, 5) + " equals " + str2.substring(7, 12) + " : " + str1.regionMatches(0, str2, 7, 5));
        System.out.println(str1.substring(0, 5) + " equals " + str2.substring(7, 12) + " ignore case : " + str1.regionMatches(true, 0, str2, 7, 5));
    }
}
