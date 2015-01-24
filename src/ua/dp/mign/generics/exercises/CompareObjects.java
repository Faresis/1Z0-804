package ua.dp.mign.generics.exercises;

import java.util.Arrays;

class Person implements Comparable<Person> {
    int age;

    Person(int age) {
        this.age = age;
    }

    public String toString() {
        return "Person { age = " + age + " } ";
    }

    public int compareTo(Person other) {
        return this.age - other.age;
    }
}

public class CompareObjects {
    public static void main(String[] args) {
        Person[] persons = { new Person(88), new Person(16) };
        System.out.println(Arrays.toString(persons));
        /*
         * If Person will not implement Comparable then
         * ClassCastExceptin will be throw.
         */
        Arrays.sort(persons, null);
        System.out.println(Arrays.toString(persons));
    }
}
