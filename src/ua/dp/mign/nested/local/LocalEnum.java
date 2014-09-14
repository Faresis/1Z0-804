package ua.dp.mign.nested.local;

class LocalEnum {
    public void initEnum() {
        /*
         * Will cause compile time error because enum types
         * may not be local.
         */
        enum Enumeration { ONE, TWO, THREE };
    }
}
