package ua.dp.mign.nested.stat.inheritance;

class Outer {
    static class InnerClass {
        void InnerClassBaseMethod() {
            System.out.println("Outer.InnerClass.InnerClassBaseMethod.");
        }
        void InnerClassCommonMethod() {
            System.out.println("Outer.InnerClass.InnerClassCommonMethod.");
        }
    }
    interface InnerInterface {
        void DoIt();
    }

    class RegularClass extends InnerClass implements InnerInterface {
        void InnerClassBaseMethod() {
            System.out.println("Outer.RegularClass.InnerClassBaseMethod.");
        }
        public void DoIt() {
            System.out.println("Outer.RegularClass.Working on it.");
        }
    }

    static class StaticRegularClass extends InnerClass implements InnerInterface {
        void InnerClassBaseMethod() {
            System.out.println("Outer.StaticRegularClass.InnerClassBaseMethod.");
        }
        public void DoIt() {
            System.out.println("Outer.StaticRegularClass.Working on it.");
        }
    }
}

class OuterEx extends Outer {
    class RegularClass extends InnerClass implements InnerInterface {
        void InnerClassBaseMethod() {
            System.out.println("OuterEx.RegularClass.InnerClassBaseMethod.");
        }
        public void DoIt() {
            System.out.println("OuterEx.RegularClass.Working on it.");
        }
    }

    static class StaticRegularClass extends InnerClass implements InnerInterface {
        void InnerClassBaseMethod() {
            System.out.println("OuterEx.StaticRegularClass.InnerClassBaseMethod.");
        }
        public void DoIt() {
            System.out.println("OuterEx.StaticRegularClass.Working on it.");
        }
    }
}

class OuterOther {
    class RegularClass extends Outer.InnerClass implements Outer.InnerInterface {
        void InnerClassBaseMethod() {
            System.out.println("OuterOther.RegularClass.InnerClassBaseMethod.");
        }
        public void DoIt() {
            System.out.println("OuterOther.RegularClass.Working on it.");
        }
    }

    static class StaticRegularClass extends Outer.InnerClass implements Outer.InnerInterface {
        void InnerClassBaseMethod() {
            System.out.println("OuterOther.StaticRegularClass.InnerClassBaseMethod.");
        }
        public void DoIt() {
            System.out.println("OuterOther.StaticRegularClass.Working on it.");
        }
    }
}

class Other extends Outer.InnerClass implements Outer.InnerInterface {
    void InnerClassBaseMethod() {
       System.out.println("Other.RegularClass.InnerClassBaseMethod.");
    }
    public void DoIt() {
       System.out.println("Other.RegularClass.Working on it.");
    }
}

class InClass {
    public static void main(String[] args) {
        Outer.InnerClass oic = new Outer.InnerClass();
        oic.InnerClassBaseMethod();
        oic.InnerClassCommonMethod();

        Outer.RegularClass org = new Outer().new RegularClass();
        org.InnerClassBaseMethod();
        org.InnerClassCommonMethod();
        org.DoIt();

        Outer.StaticRegularClass osrg =  new Outer.StaticRegularClass();
        osrg.InnerClassBaseMethod();
        osrg.InnerClassCommonMethod();
        osrg.DoIt();

        OuterEx.RegularClass oxrg = new OuterEx().new RegularClass();
        oxrg.InnerClassBaseMethod();
        oxrg.InnerClassCommonMethod();
        oxrg.DoIt();

        OuterEx.StaticRegularClass oxsrg = new OuterEx.StaticRegularClass();
        oxsrg.InnerClassBaseMethod();
        oxsrg.InnerClassCommonMethod();
        oxsrg.DoIt();

        OuterOther.RegularClass otrg = new OuterOther().new RegularClass();
        otrg.InnerClassBaseMethod();
        otrg.InnerClassCommonMethod();
        otrg.DoIt();

        OuterOther.StaticRegularClass otsrg = new OuterOther.StaticRegularClass();
        otsrg.InnerClassBaseMethod();
        otsrg.InnerClassCommonMethod();
        otsrg.DoIt();

        Other o = new Other();
        o.InnerClassBaseMethod();
        o.InnerClassCommonMethod();
        o.DoIt();
    }
}
