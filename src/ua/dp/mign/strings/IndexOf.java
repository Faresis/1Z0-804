package ua.dp.mign.strings;

class IndexOf {
    public static void main(String[] args) {
        String string = "The quick brown fox jumps over the lazy dog";
        System.out.println("Index of quick is : " + string.indexOf("quick"));
        System.out.println("Index of fox is : " + string.indexOf("fox"));
        System.out.println("Index of e is : " + string.indexOf('e'));
        System.out.println("Index of e starting from 3 is : " + string.indexOf('e', 3));
        System.out.println("Last index of e is : " + string.lastIndexOf('e'));
    }
}
