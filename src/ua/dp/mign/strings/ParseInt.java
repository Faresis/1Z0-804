package ua.dp.mign.strings;

class ParseInt {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("101",2));
        System.out.println(Integer.parseInt("111",2));
        System.out.println(Integer.parseInt("111",8));
        System.out.println(Integer.parseInt("111"));
        System.out.println(Integer.parseInt("111",10));
        // will cause NumberFormatException
        //System.out.println(Integer.parseInt("211",2));
    }
}
