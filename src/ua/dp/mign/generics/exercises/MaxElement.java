package ua.dp.mign.generics.exercises;

import java.util.List;
import java.util.Arrays;

class MaxElement {
    /*
     * Method finds max element in the specified list within specified range.
     */
    public static <T extends Comparable<T>> int maxElement(List<T> list, int begin, int end) {
        int max = begin;
        T maxElem = list.get(begin);
        for(int i = begin + 1; i <= end; i++) {
            T current = list.get(i);
            if(maxElem.compareTo(current) < 0) {
                max = i;
                maxElem = current;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 3, 4, 10, 2, 8, 6, 35, 1, 4, 22, 5);
        List<Double> doubles = Arrays.asList(2.0, 43.0, 22.0, 7.0, 6.0, 15.0);

        System.out.println("Max element in integers between 0 and 5 is : " + maxElement(integers, 0, 5));
        System.out.println("Max element in integers between 0 and 11 is : " + maxElement(integers, 0, 11));
        System.out.println("Max element in integers between 8 and 11 is : " + maxElement(integers, 8, 11));
        System.out.println("Max element in integers between 7 and 11 is : " + maxElement(integers, 7, 11));
        System.out.println("Max element in doubles between 0 and 5 is : " + maxElement(doubles, 0, 5));
        System.out.println("Max element in doubles between 2 and 5 is : " + maxElement(doubles, 2, 5));
        System.out.println("Max element in doubles between 0 and 3 is : " + maxElement(doubles, 0, 3));
    }
}
