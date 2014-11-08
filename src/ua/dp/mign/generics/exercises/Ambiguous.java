package ua.dp.mign.generics.exercises;

/*
 * As far as generic type parameter is not specified
 * it will be substituted with Object reference.
 */
class LastError<T> {
    private T lastError;
    void setError(T t) {
        lastError = t;
        System.out.println("LastError");
    }
}

/*
 * Since StringLastGenericError extends LastError<String> it inherits
 * LastError.setError(String t). Current setError(S s) will be treated as
 * overloaded one for LastError.setError(String t) because separate 
 * generic type parameter is used for method parameter. And even if
 * S extends String would be used it would be still treated as overloading
 * because it can be substituted with any type extending String during
 * usage and so overriding can't be applied. So as a result we have
 * two overloaded methods in the StringLastGenericError interface:
 * setError(S s) and setError(String t). It will compile.
 */
class StringLastGenericError<S extends CharSequence> extends LastError<String> {
    void setError(S s) {
        System.out.println("StringLastGenericError");
    }
}

class Ambiguous {
    public static void main(String[] args) {
        String str = "Error string";
        /*
         * In this case everything is OK because CharSequence is used as a type
         * parameter and so we get two different method signatures in the
         * class interface: setError(CharSequence s) and setError(String t)
         */
        StringLastGenericError<CharSequence> err1 = new StringLastGenericError<>();
        err1.setError(str);

        /*
         * In this case things go wrong because String is used as a type
         * parameter and so we get two method signatures with same parameter types
         * in the class interface: setError(String s) from StringLastGenericError
         * and setError(String t) from LastError. They can't be treated as
         * overriding ones because this substitution is applicable only for
         * this specific case and can't be applied for all the cases.
         * As a result compilation error arise.
         */
        StringLastGenericError<String> err2 = new StringLastGenericError<>();
        //err2.setError(str);
    }
}
