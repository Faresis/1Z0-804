package ua.dp.mign.enums;

public enum Enumeration {
    ONE("1",3), TWO("2",2), THREE("3",1);

    Enumeration(String desc, int num) {
        this.desc = desc;
        this.num = num;
    }

    public String toString() {
        return this.name().toLowerCase();
    }

    private String desc;
    private int num;

    public static void main(String[] args) {
        System.out.println(Enumeration.ONE.name());
        System.out.println(Enumeration.ONE.toString());
        System.out.println(Enumeration.ONE.ordinal());
        System.out.println(Enumeration.ONE.desc);
        System.out.println(Enumeration.ONE.num);
    }
}
