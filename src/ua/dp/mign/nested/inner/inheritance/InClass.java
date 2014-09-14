package ua.dp.mign.nested.inner.inheritance;

/* Outer -> Inner */
class Outer {
    abstract class InnerAbstractClass {
        abstract void InnerAbstractClassMethod();
        void InnerBaseMethod() {
            System.out.println("InnerBaseMethod in InnerAbstractClass.");
        }
    }

    class InnerAbstractExClass extends InnerAbstractClass {
        void InnerAbstractClassMethod() {
            System.out.println("InnerAbstractClassMethod in Outer.InnerAbstractExClass.");
        }
    }
}

/* Extended Outer -> Extended Inner */
class OuterEx extends Outer {
    class InheritedInnerAbstractExClass extends InnerAbstractClass {
        void InnerAbstractClassMethod() {
            System.out.println("InnerAbstractClassMethod in OuterEx.InheritedInnerAbstractExClass.");
        }
    }
}

/* Other Outer -> Inner -> Extend Other Inner */
class OuterOther {
    class InheritedInnerAbstractExClass extends Outer.InnerAbstractClass {
        InheritedInnerAbstractExClass(Outer o) {
            o.super();
        }
        void InnerAbstractClassMethod() {
            System.out.println("InnerAbstractClassMethod in OtherOuter.InheritedInnerAbstractExClass.");
        }
    }
}

/*
 * Outer top level class can extend inner class declared
 * in another class. But it is required to provide a constructor
 * which receive Outer class as a first argument and
 * first call in such a constructor should be to a super()
 * constructor of the class we are extending.
 */
class OuterAbstractEx extends Outer.InnerAbstractClass {
    OuterAbstractEx(Outer obj) {
        obj.super();
    }
    void InnerAbstractClassMethod() {
        System.out.println("InnerAbstractClassMethod in OuterAbstractEx.");
    }
}

class InClass {
    public static void main(String[] args) {
        Outer o = new Outer();
        Outer.InnerAbstractClass iax = new Outer().new InnerAbstractExClass(); // inner class - created with Outer prefix
        Outer.InnerAbstractClass oxax = new OuterEx().new InnerAbstractExClass();
        Outer.InnerAbstractClass oxix = new OuterEx().new InheritedInnerAbstractExClass();
        Outer.InnerAbstractClass ooix = new OuterOther().new InheritedInnerAbstractExClass(o);
        Outer.InnerAbstractClass ex = new OuterAbstractEx(o); // top level class - created without namespace
        iax.InnerBaseMethod();
        iax.InnerAbstractClassMethod();
        ex.InnerBaseMethod();
        ex.InnerAbstractClassMethod();
        oxix.InnerBaseMethod();
        oxix.InnerAbstractClassMethod();
        oxax.InnerBaseMethod();
        oxax.InnerAbstractClassMethod();
        ooix.InnerBaseMethod();
        ooix.InnerAbstractClassMethod();
    }
}
