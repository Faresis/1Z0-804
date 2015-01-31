package ua.dp.mign.mock1;

import java.util.ArrayList;
import java.util.List;

class Wildcard_33 {
    public static <T> List<T> asList1(T... elements) {
        ArrayList<T> temp = new ArrayList<>();
        for(T element : elements) {
            temp.add(element);
        }
        return temp;
    }

    /*
     * In this case an array of some specific elements
     * will be passed. Inside this method a list of 
     * unknown elements is created. We can't put specific
     * elements to the list of unknown elements because
     * we don't know if it will be able to handle them.
     * In the same time we can assign reference of list
     * with specific elements to the variable of
     * unknown list type.
     */
    public static <T> List<?> asList2(T... elements) {
        ArrayList<?> temp = new ArrayList<>();
        for(T element : elements) {
            temp.add(element);
        }
        return temp;
    }

    public static <T> List<?> asList3(T... elements) {
        ArrayList<T> temp = new ArrayList<>();
        for(T element : elements) {
            temp.add(element);
        }
        return temp;
    }

    public static <T> List<?> asList4(T... elements) {
        List<T> temp = new ArrayList<T>();
        for(T element : elements) {
            temp.add(element);
        }
        return temp;
    }
}
