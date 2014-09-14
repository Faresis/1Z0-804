package ua.dp.mign.nested.stat.interfaces;

interface Outer {
    void OuterMethod();
    class InnerClass {
        void InnerClassMethod() {
            System.out.println("InnerClassMethod.");
        }
    }
    interface InnerInterface {
        void InnerInterfaceMethod();
    }
}

public class InInterface {
    public static void main(String [] args) {
        Outer.InnerClass ic = new Outer.InnerClass();
        Outer.InnerInterface ii = new Outer.InnerInterface() {
            public void InnerInterfaceMethod() {
                System.out.println("InnerInterfaceMethod.");
            }
        };
        Outer o = new Outer() {
            public void OuterMethod() {
                System.out.println("OuterMethod.");
            }
        };
        o.OuterMethod();
        ic.InnerClassMethod();
        ii.InnerInterfaceMethod();
    }
}
