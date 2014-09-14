package ua.dp.mign.nested.local;

class LocalInterface {
    public void initInterface() {
        /*
         * Will cause compile time error because interfaces
         * may not be local.
         */
        interface Contract {
            int getData();
        };
    }
}
