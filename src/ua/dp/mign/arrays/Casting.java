package ua.dp.mign.arrays;

class Casting {
    public static void main(String[] args) {
        String[] strings = { "Hello", "World" };
        Object[] objects = strings;

        // this will cause ArrayStoreException
        objects[0] = new Integer(25);

        Object[] generic = new Object[10];
        // this will cause ClassCastException
        strings = (String[])generic;
    }
}
