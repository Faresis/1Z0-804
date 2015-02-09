package ua.dp.mign.mock2;

class Replace_18 {
    /*
     * This example shows that both replace() and replaceAll()
     * methods replace all occurrences in the string and not
     * the only first one.
     * To replace first occurrence replaceFirst() should be used
     */
    public static void main(String[] args) {
        String talk = "Pick a little, talk a little, pick a little, talk a little, cheep cheep cheep, talk a lot, pick a little more";
        String eat = talk.replaceAll("talk", "eat").replace("cheep", "burp");
        System.out.println(eat);
    }
}
