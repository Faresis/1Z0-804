package ua.dp.mign.overloading;

import static java.lang.System.out;

class OverloadedInheritance {
    public static void process(PersonImplEx p1, Person p2) {
        out.println("PersonImplEx, Person");
    }
    public static void process(Worker p1, Worker p2) {
        out.println("Worker, Worker");
    }
    /* exact match first */
    public static void process(PersonImplEx p) {
        out.println("PersonImplEx: " + p);
    }
    /* base classes goes next */
    public static void process(PersonImpl p) {
        out.println("PersonImpl: " + p);
    }
    /* next interface is used */
    public static void process(Person p) {
        out.println("Person: " + p);
    }
    public static void process(Worker w) {
        out.println("Worker: " + w);
    }
    /* Object goes after interfaces */
    public static void process(Object p) {
        out.println("Object: " + p);
    }
    /* params goes last one */
    public static void process(PersonImpl... p) {
        out.println("PersonImpl...");
    }
    public static void main(String[] args) {
        PersonImplEx p1 = new PersonImplEx();
        PersonImplEx p2 = new PersonImplEx();
        process(p1);
        process(p2);
        process(p1, p2);
    }
}

interface Person {
    int getAge();
}

interface Worker {
    void doWork();
}

class PersonImpl implements Worker, Person {
    public int getAge() {
        return 8;
    }

    public void doWork() {}

    public String toString() {
        return "" + getAge();
    }
}

class PersonImplEx extends PersonImpl implements Worker, Person {
    public int getAge() {
        return 10;
    }
}
