package ua.dp.mign.mock2;

import java.util.ArrayList;

class ArrayListRemoveTest_17 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(new Integer(2));
        list.add(1);
        list.add(5);
        /*
         * List has two overloaded versions of the remove
         * method.
         * First one receive int index and remove item
         * at this index.
         * Second one receive an object and remove first
         * occurrence in the list
         */
        System.out.println("Full list: " + list);

        // this one will remove item at index 2 [5]
        list.remove(2);
        System.out.println("After list.remove(2) : " + list);
        // this one will remove Integer(2) item [2]
        list.remove((Object)2);
        System.out.println("After list.remove((Object)2) : " + list);
    }
}
