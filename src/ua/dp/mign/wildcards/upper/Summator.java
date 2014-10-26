package ua.dp.mign.wildcards.upper;

import java.util.Arrays;
import java.util.List;

/*
 * There are cases when same functionality can be implemented
 * by using wildcards or pure generics functionality with
 * no difference.
 */
class Util {
    /*
     * Wildcards implementation.
     */
    double wildcardSumOfList(List<? extends Number> lst) {
        double res = 0.0;
        for(Number num : lst) {
            res += num.doubleValue();
        }
        return res;
    }

    /*
     * Generics implementation.
     */
    <T extends Number> double genericSumOfList(List<T> lst) {
        double res = 0.0;
        for(T num : lst) {
            res += num.doubleValue();
        }
        return res;
    }
}

class Summator {
    public static void main(String[] args) {
        List<Float> fltList = Arrays.asList(2.0f, 3.5f, 4.1f);
        List<Double> dblList = Arrays.asList(4.0, 3.3, 7.1);
        List<Integer> intList = Arrays.asList(1, 2, 3);

        Util util = new Util();

        System.out.println("Sum is: " + util.wildcardSumOfList(fltList));
        System.out.println("Sum is: " + util.wildcardSumOfList(dblList));
        System.out.println("Sum is: " + util.wildcardSumOfList(intList));

        System.out.println("Sum is: " + util.genericSumOfList(fltList));
        System.out.println("Sum is: " + util.genericSumOfList(dblList));
        System.out.println("Sum is: " + util.genericSumOfList(intList));
    }
}
