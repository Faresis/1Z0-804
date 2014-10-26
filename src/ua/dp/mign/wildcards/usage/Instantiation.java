package ua.dp.mign.wildcards.usage;

import java.util.List;
import java.util.ArrayList;

class Instantiation {
    public static void main(String[] args) {

        /*
         * Compilation error because wildcards can't be used during generic
         * class instance creation or generic method invocation.
         */
        //List<? extends Integer> numList = new ArrayList<? extends Integer>();

        /*
         * In current example it works OK because during type erasure first bound
         * is used to substitute a type parameter. In current case this is Integer.
         * This information is used as Target Type for Type Inference. As a result
         * List<Integer> will be instantiated.
         */
        List<? extends Integer> numList = new ArrayList<>();
    }
}
