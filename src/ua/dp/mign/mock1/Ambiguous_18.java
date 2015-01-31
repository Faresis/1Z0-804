package ua.dp.mign.mock1;

class base1 {
    protected int var;
}

interface base2 {
    int var = 10;
}

/*
 * This code will result in compilation error. Because
 * Ambiguous_18 has two variables named var in its
 * context and direct usage of this variable will result
 * in ambiguity and as a result in compilation error.
 */
class Ambiguous_18 extends base1 implements base2 {
    public static void main(String[] args) {
        Ambiguous_18 b = new Ambiguous_18();
        base1 b1 = b;
        base2 b2 = b;
        System.out.println("var: " + b.var);
        System.out.println("var: " + b1.var);
        System.out.println("var: " + b2.var);
    }
}
