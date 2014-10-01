package ua.dp.mign.generics.diamond;

class GenericWrapper<T> {
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
}

class Diamond {
    public static void main(String[] args) {
        /*
         * Diamond syntax available since Java 7. There is no need to specify
         * generic type parameter in the new statement. It is inferred from 
         * the declaration statement.
         */
        GenericWrapper<Integer> numWrapper = new GenericWrapper<>(new Integer(15));
        System.out.println(numWrapper);

        /*
         * If diamond <> operator is omitted newly created object is treated as 
         * raw data type. Which can lead to runtime errors.
         */
        GenericWrapper<Integer> objWrapper = new GenericWrapper(new String("bam"));
        System.out.println(objWrapper);
        // this will cause a runtime exception
        Integer bam = objWrapper.getEntity();
    }
}
