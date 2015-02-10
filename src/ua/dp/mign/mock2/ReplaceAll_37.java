package ua.dp.mign.mock2;

class ReplaceAll_37 {
    /*
     * In this example str.replaceAll takes regex expression
     * as a first argument. Since "." matches any character
     * all characters in the str string are replaced with
     * "," character.
     */
    public static void main(String[] args) {
        String str = "A.B.C!";
        System.out.println(str.replaceAll(".", ",").replace("!","?"));
    }
}
