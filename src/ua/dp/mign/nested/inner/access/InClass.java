package ua.dp.mign.nested.inner.access;

class Outer {
    private int outerData = 1;
    private static int outerStaticData = 2;

    private void OuterMethod() {
        System.out.println("OuterMethod in Outer.");
    }

    private static void OuterStaticMethod() {
        System.out.println("OuterStaticMethod in Outer.");
    }

    /*
     * Inner classes can't contain static members unless constant.
     */
    class Inner {
        private int innerData = 3;
        //private static int innerStaticData = 4;
        public static final String CONSTANT = "CONSTANT";
        public static final int NUM = 42;

        private void InnerMethod() {
            System.out.println("InnerMethod.");
        }

        private int outerData = 4;
        private int outerStaticData = 5;

        private void OuterMethod() {
            System.out.println("OuterMethod in Inner.");
        }

        private void OuterStaticMethod() {
            System.out.println("OuterStaticMethod in Inner.");
        }

        /*
        private static void InnerStaticMethod() {
            System.out.println("InnerStaticMethod.");
        }
        */

        /*
         * Inner classes can implicitly access all members
         * of the Outer class. In case if they are not
         * overlapped with local ones. Otherwise explicit
         * call through Outer.this will be required.
         */
        void Process() {
            System.out.println(Outer.this.outerData);
            System.out.println(Outer.this.outerStaticData);
            Outer.this.OuterMethod();
            Outer.this.OuterStaticMethod();
        }

        void ProcessOverlapped() {
            System.out.println(outerData);
            System.out.println(outerStaticData);
            OuterMethod();
            OuterStaticMethod();
        }
        
        /*
         * Inner classes can explicitly access all members
         * of the Outer class.
         */
        void Process(Outer o) {
            System.out.println(o.outerData);
            System.out.println(o.outerStaticData);
            o.OuterMethod();
            o.OuterStaticMethod();
        }
    }

    /*
     * Outer class can't implicitly access members of an
     * Inner class. Because they are share many-to-one
     * relationship.
     */
    /*
    void Process() {
        System.out.println(innerData);
        InnerMethod();
    }
    */
    void Process(Inner in) {
        System.out.println(in.innerData);
        in.InnerMethod();
    }
}

class InClass {
    public static void main(String[] args) {
        Outer o = new Outer();
        Outer.Inner in = new Outer().new Inner();
        in.Process();
        o.Process(in);
        in.ProcessOverlapped();
        System.out.println("Static constant from inner: " + in.CONSTANT);
        System.out.println("Static num from inner: " + in.NUM);
    }
}
