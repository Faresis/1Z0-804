package ua.dp.mign.strings;

class StartsEndsWith {
    public static void main(String[] args) {
        String string = "Hello, world!";
        System.out.println("Starts with hello: " + string.startsWith("hello"));
        System.out.println("Starts with Hello: " + string.startsWith("Hello"));
        System.out.println("Starts with world from 7 : " + string.startsWith("world", 7));
        System.out.println("Starts with World from 7 : " + string.startsWith("World", 7));
        System.out.println("Ends with world! : " + string.endsWith("world!"));
        System.out.println("Ends with \"\" : " + string.endsWith(""));
        System.out.println("Starts with \"\" : " + string.startsWith(""));
    }
}
