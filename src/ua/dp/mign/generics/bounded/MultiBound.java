package ua.dp.mign.generics.bounded;

interface Worker {
    void doWork();
}

interface Processor {
    void process(Object o); 
}

class Person {
    int age;
    int height;
    Person(int age, int height) {
        this.age = age;
        this.height = height;
    }
}

class Employee extends Person implements Processor, Worker {
    Employee(int age, int height) {
        super(age, height);
    }
    public void doWork() {
        System.out.println("Employee is working");
    }
    public void process(Object o) {
        System.out.println("Employee processing " + o);
    }
}

class MultiBound {
    /*
     * With multiple bounds members of all mentioned types are available
     * inside a method: age & height from Person, process from Processor
     * and doWork from Worker.
     */
    public static <T extends Person & Worker & Processor> void test(T obj) {
        System.out.println("Age: " + obj.age);
        System.out.println("Height: " + obj.height);
        obj.process("brick");
        obj.doWork();
    }

    public static void main(String[] args) {
        test(new Employee(25, 180));

        /*
         * Will not compile since bound condition is not satisfied.
         */
        //test(new Person(25, 180));
        //test(new Object());
        //test("hello");
    }
}
