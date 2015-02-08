package ua.dp.mign.mock2;

class GenericCast_11 {
    /*
     * During compilation E is substituted
     * by its lower bound. Object in this
     * case. So the method body will look
     * like: return (Object) item.
     * Actually Object reference will be cast
     * to the Object type. So there will
     * never be a ClassCastException inside
     * of this method.
     */
    static <E> E cast(Object item) {
        E var = (E) item;
        System.out.println(var);
        return var;
    }

    public static void main(String[] args) {
        /*
         * Autoboxing is applied here and int
         * is boxed as an Integer
         */
        Object o1 = 10;
        Object s = "Hello";
        int i = 10;
        Integer anInteger = 10;

        /*
         * Object is passed as an object.
         * It is casted to the Object type inside a method.
         * Later it is casted to the Integer type while
         * assigned to the i1
         */
        Integer i1 = cast(o1);
        /*
         * int value is autoboxed and passed as an Integer.
         * Inside a method it is casted to the Object type.
         * Later it is casted to the Integer type while
         * assigned to the i2.
         */
        Integer i2 = cast(i);
        /*
         * 10 (int) value is autoboxed and passed as an Integer.
         * Inside a method it is casted to the Object type.
         * Later it is casted to the Integer type while
         * assigned to the i3.
         */
        Integer i3 = cast(10);
        /*
         * Integer is passed as an object.
         * It is casted to the Object type inside a method.
         * Later it is casted to the Integer type while
         * assigned to the i4
         */
        Integer i4 = cast(anInteger);

        // all variables are successfully printed
        System.out.printf("i1 = %d, i2 = %d, i3 = %d, i4 = %d%n",
                          i1, i2, i3, i4);

        /*
         * String is passed as an Object to the method.
         * It is casted to Object inside a method and
         * no exception is thrown.
         * Later it is casted to the Integer type while
         * assigned to the i5 variable.
         * Here a ClassCastException is raised.
         */
        Integer i5 = cast(s);
    }
}
