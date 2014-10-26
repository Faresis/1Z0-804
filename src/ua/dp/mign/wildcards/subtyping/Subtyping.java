package ua.dp.mign.wildcards.subtyping;

import java.util.List;
import java.util.ArrayList;

class A {}
class B extends A {}

class Subtyping {
    
    public static void main(String[] args) {
        // Normal polymorphic link.
        B b = new B();
        A ab = b;

        // But it doesn't work with generics.
        //List<B> lb = new ArrayList<>();
        //List<A> la = lb;

        /*
         * And this work OK with upper bounded wildcards.
         * So if any functionality returns more specific
         * type to allow us to work with its rich features
         * it is not a problem to pass it to a method
         * where less specific type is expected while
         * it is implemented with usage of wildcards.
         */
        List<B> lb = new ArrayList<>();
        List<? extends B> lbw = lb;
        List<? extends A> la = lbw;

        /*
         * And this works in back direction with lower
         * bounded wildcards. Super of base class can
         * be handled where super of its child is expected.
         */
        List<? super A> sa = new ArrayList<>();
        List<? super B> sb = sa;
    }
}
