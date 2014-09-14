package ua.dp.mign.enums;

public class InClass {
    /*
     * To be accessed outside of the package
     * enumeration should be declared as public.
     * It is not declared as public implicitly.
     * Although it is declared as static
     * implicitly. Thus it cannot access outer
     * class reference InClass.this from the
     * static context.
     */
    public enum Enumeration {
        ONE, FOUR, FIVE, SIX;

        public String toString() {
            // return InClass.this.toString();
            // can't access in the static context.
            return this.name().toLowerCase();
        }
    }
}
