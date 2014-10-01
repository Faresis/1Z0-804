package ua.dp.mign.generics.raw;

import java.util.*;

class RawTest {
    public static void main(String[] args) {
        List list = new LinkedList();
        list.add("First");
        list.add("Second");
        List<String> strList = list;
        /*
         * This will result in a compilation error. Because generic list
         * type String is not applicable with passed argument which is of
         * int type.
         */
        //strList.add(10);
        for(Iterator<String> itemItr = strList.iterator(); itemItr.hasNext();) {
            System.out.println("Item: " + itemItr.next());
        }

        List<String> strList2 = new LinkedList<>();
        strList2.add("First");
        strList2.add("Second");
        List list2 = strList2;
        /*
         * This will compile successfully because currently used list
         * is a raw type which allows us to pass objects of any type
         * to it. But problems will occur when we will try to retrieve
         * them from it.
         */
        list2.add(10);
        
        /*
         * While iterating through raw list using Object reference
         * there is no problems. But Object reference is not always
         * enough.
         */
        for(Iterator itemItr = list2.iterator(); itemItr.hasNext();) {
            System.out.println("Item: " + itemItr.next());
        }
        /*
         * If we will try to use type specific reference to retrieve objects
         * from a raw list we have a risk to get ClassCastException if there
         * were objects of incompatible type put in this list.
         */
        for(Iterator<String> itemItr = list2.iterator(); itemItr.hasNext();) {
            System.out.println("Item: " + itemItr.next());
        }
    }
}
