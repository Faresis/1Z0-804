package ua.dp.mign.enums;

/*
 * In current implementation will cause compile time errors
 * because enum elements from the line #2 should be defined
 * first inside enum declaration. So if lines #1 and #2 will
 * be swapped it will compile successfully.
 */
enum BrokenEnum {
    private int data; // #1

    ONE(1), TWO(2), THREE(3); // #2

    private BrokenEnum(int data) {
        this.data = data;
    }
}
