package ua.dp.mign.mock2;

class PrivateOverride_26 {
    private void foo() {
        System.out.println("Base.foo()");
    }
    void bar() {
        System.out.println("Base.bar()");
    }

    /*
     * In this scenario Base.foo() method can't
     * be overridden because it is declared as
     * private. And no one from derived classes
     * can override it.
     * So all private methods can be considered
     * final.
     */
    public static void main(String[] args) {
        PrivateOverride_26 po = new DerivedClass();
        // Base.foo() will be printed
        po.foo();
        // Derived.bar() will be printed
        po.bar();
    }
}

class DerivedClass extends PrivateOverride_26 {
    void foo() {
        System.out.println("Derived.foo()");
    }
    void bar() {
        System.out.println("Derived.bar()");
    }
}
