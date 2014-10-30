package ua.dp.mign.generics.methods;

/*
 * Type parameter on class level is instance one.
 * It can be used within static context e.g. static
 * methods or variables. This will cause a compilation
 * error.
 */
/*
class Static<T> {
    static T field;
    public static T aMethod(T obj) {
        return obj;
    }
}
*/

class StaticMethod {
    /*
     * On the other hand if generic type parameter is
     * declared within static method it lies in the
     * static context and can be used within the same
     * static method.
     */
    public static <T> T aMethod(T obj) {
        return obj;
    }
}
/*
 * Same problem as in the first example. As far as
 * field declaration can't contain generic type
 * declaration it can use only one declared on the
 * class level. But for static fields even those
 * are not reachable because of static context
 * and thus generic static field are not allowed.
 */
/*
class StaticField<T> {
    static T field;
}
*/
