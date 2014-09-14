package ua.dp.mign.nested.inner.interfaces;

class Outer {
    interface InnerInterface {
        void InnerInterfaceMethod();
    }
    static interface InnerStaticInterface {
        void InnerStaticInterfaceMethod();
    }
    abstract class AbstractClass {
        abstract void AbstractClassMethod();
    }
}

class InClass {
    public static void main(String[] args) {
        Outer.InnerInterface ii = new Outer.InnerInterface() {
            public void InnerInterfaceMethod() {
                System.out.println("InnerInterfaceMethod.");
            }
        };
        ii.InnerInterfaceMethod();

        Outer.InnerStaticInterface isi = new Outer.InnerStaticInterface() {
            public void InnerStaticInterfaceMethod() {
                System.out.println("InnerStaticInterfaceMethod.");
            }
        };
        isi.InnerStaticInterfaceMethod();

        Outer.AbstractClass oac = new Outer().new AbstractClass() {
            void AbstractClassMethod() {
                System.out.println("AbstractClassMethod.");
            }
        };
        oac.AbstractClassMethod();
    }
}
