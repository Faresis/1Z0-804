package ua.dp.mign.generics.wrappers;

class GenericWrapper <T> {
    private T entity;
    public GenericWrapper(T entity) {
        this.entity = entity;
    }
    public T getEntity() {
        return entity;
    }
    public String toString() {
        return "[ " + entity + " ]";
    }

    /*
     * Program compiles successfully. Programmer's mistakes
     * related to type safety are detected during compile time
     * because of generics. 
     */
    public static void main(String[] args) {
        GenericWrapper<String> wordWrapper = new GenericWrapper<String>("word");
        System.out.println(wordWrapper);
        /*
         * String object was stored inside the wordWrapper.
         * Since generic type holder is used cast is not needed.
         */
        String word = wordWrapper.getEntity();

        GenericWrapper<Double> numberWrapper = new GenericWrapper<Double>(100.0);
        System.out.println(numberWrapper);
        /*
         * Double object was stored inside the numberWrapper.
         * Attempt to assign Double value to Float variable
         * will be detected during comile time.
         */
        //Float number = numberWrapper.getEntity();
        Double number = numberWrapper.getEntity();
    }
}
