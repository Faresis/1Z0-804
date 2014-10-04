package ua.dp.mign.generics.methods;

class Generic<T> {
    T entity;

    Generic(T entity) {
        this.entity = entity;
    }

    /*
     * Overlapping is not a problem since
     * generic type parameter declared in a class
     * and generic type parameter declared in a method
     * are treated as different types.
     */
    <T> void doWork(T obj) {
        System.out.println(obj);
    }

    void print() {
        System.out.println(entity);
    }
}

class Overlapping {
    public static void main(String[] args) {
        Generic<Integer> intGen = new Generic<>(new Integer(5));
        intGen.print();
        intGen.doWork(new Float(50));
        intGen.doWork("hello");
    }
}
