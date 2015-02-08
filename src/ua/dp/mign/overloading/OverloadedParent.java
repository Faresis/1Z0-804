package ua.dp.mign.overloading;

class Parent {
    public void print(int i) {
        System.out.println("int: " + i);
    }
}

class Child extends Parent {
    public void print(Object i) {
        System.out.println("Object: " + i);
    }
}

class OverloadedParent {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = child;
        child.print(2);
        parent.print(2);
    }
}
