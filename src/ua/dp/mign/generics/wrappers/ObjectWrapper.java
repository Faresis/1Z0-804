package ua.dp.mign.generics.wrappers;

class ObjectWrapper {
    private Object entity;
    public ObjectWrapper(Object entity) {
        this.entity = entity;
    }
    public Object getEntity() {
        return entity;
    }
    public String toString() {
        return "[ " + entity + " ]";
    }

    /*
     * Program compiles successfully but because of programmer's
     * mistake ClassCastException is thrown which was not detected
     * during compile time.
     */
    public static void main(String[] args) {
        ObjectWrapper wordWrapper = new ObjectWrapper("word");
        System.out.println(wordWrapper);
        /*
         * String object was stored inside the wordWrapper.
         * So cast to String is correct. But can't be checked
         * at compile time.
         */
        String word = (String)wordWrapper.getEntity();

        ObjectWrapper numberWrapper = new ObjectWrapper(100.0);
        System.out.println(numberWrapper);
        /*
         * Double object was stored inside the numberWrapper.
         * So cast to Float will result in ClassCastException.
         * But this can't be checked at compile time.
         */
        Float number = (Float)numberWrapper.getEntity();
    }
}
