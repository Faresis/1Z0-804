package ua.dp.mign.nested.stat.access;

class Outer {
    private int outerData = 1;
    private static int outerStaticData = 2;
    public void OuterPublicMethod() {
    }
    void OuterMethod() {
        System.out.println("OuterMethod.");
    }
    private static void OuterStaticPrivateMethod() {
        System.out.println("OuterStaticPrivateMethod.");
    }
    private void OuterPrivateMethod() {
        System.out.println("OuterPrivateMethod.");
    }
    /*
     * Outer class can access to InnerClass private
     * members only through InnerClass object
     * reference.
     */
    void Process(InnerClass ic) {
        System.out.println(ic.innerData);
        System.out.println(ic.innerStaticData);
        ic.InnerPrivateMethod();
        ic.InnerStaticPrivateMethod();
    }

    static class InnerClass {
        private int innerData = 3;
        private static int innerStaticData = 4;
        /* 
         *  Without reference to the Outer class object
         *  InnerClass can access only static private fields
         *  of the Outer class. Because it lays in the
         *  static context. So static members of an outer
         *  class are merged into inner class context.
         */
        void InnerClassMethod() {
            //System.out.println(outerData);
            System.out.println(outerStaticData);
            //OuterPrivateMethod();
            OuterStaticPrivateMethod();
        }
        public void InnerClassPublicMethod() {
        }
        private static void InnerStaticPrivateMethod() {
            System.out.println("InnerStaticPrivateMethod.");
        }
        private void InnerPrivateMethod() {
            System.out.println("InnerPrivateMethod.");
        }
        /*
         * Using explicit reference to the Outer class object
         * InnerClass can access all its private fields.
         */
        void Process(Outer o) {
            System.out.println(o.outerData);        // using object
            System.out.println(outerStaticData);
            o.OuterPrivateMethod();                 // using object
            OuterStaticPrivateMethod();
        }
    }

    interface InnerInterface {
        void InnerInterfaceMethod();
    }
}

class InClass {
    public static void main(String... args) {
        Outer.InnerClass ic = new Outer.InnerClass();
        Outer o = new Outer();
        ic.Process(o);
        o.Process(ic);
    }
}
