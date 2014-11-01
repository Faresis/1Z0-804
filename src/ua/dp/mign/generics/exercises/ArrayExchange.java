package ua.dp.mign.generics.exercises;

import java.util.Arrays; 

class ArrayExchange {
    /*
     * Swaps first and last elements of an array.
     */
    static <T> void swap(T[] arr) {
        T tmp = arr[0];
        arr[0] = arr[arr.length -1];
        arr[arr.length - 1] = tmp;
    }

    public static void main(String[] args) {
        Integer[] integers = { 1, 2, 3, 4, 5};
        Double[] doubles = { 6.0, 7.0, 8.0, 9.0, 10.0 };
        String[] strings = { "Hello", "World" };

        System.out.println("Before swap.");
        System.out.println(Arrays.toString(integers));
        System.out.println(Arrays.toString(doubles));
        System.out.println(Arrays.toString(strings));
        System.out.println();

        swap(integers);
        swap(doubles);
        swap(strings);

        System.out.println("After swap.");
        System.out.println(Arrays.toString(integers));
        System.out.println(Arrays.toString(doubles));
        System.out.println(Arrays.toString(strings));
    }
}
