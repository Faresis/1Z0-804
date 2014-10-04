package ua.dp.mign.generics.bounded;

interface Worker {
    void doWork();
}

interface Processor {
    void process(Object o); 
}

class Person {
    int age;
    int heigh;
}

class MultiBound {
    public static <T extends Number> void process(T obj) {
        System.out.println(obj.doubleValue());
    }

    public static void main(String[] args) {
        process(new Integer(45));
        process(new Double(46));
        process(new Float(47));

        /*
         * Will not compile since bound condition is not satisfied.
         */
        //process(new Object());
        //process("hello");
    }
}
