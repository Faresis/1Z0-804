package ua.dp.mign.generic.exceptions;

/*
 * Will result in compilation error.
 * Since generic classes are not allowed to
 * extend Throwable class or any of its derived
 * classes.
 */
class GenericException<T> extends Throwable {
}
