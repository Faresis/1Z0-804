package ua.dp.mign.otherpkg;

import ua.dp.mign.enums.InClass;
import ua.dp.mign.enums.Enumeration;

class EnumerationUser {
    public static void main(String[] args) {
        /*
         * static values method returns all declared enum instances.
         */
        for(InClass.Enumeration var : InClass.Enumeration.values()) {
            System.out.println(var);
            System.out.println(var.name());
        }

        // valueOf method returns enum instance by its string name.
        InClass.Enumeration enm = InClass.Enumeration.valueOf("FOUR");
        System.out.println(enm);
        
        // comparing using ==
        System.out.println("enm == InClass.Enumeration.FOUR: " + (enm == InClass.Enumeration.FOUR));

        // equals
        System.out.println("enm.equals(InClass.Enumeration.FOUR): " + (enm.equals(InClass.Enumeration.FOUR)));

        // equals
        System.out.println("Enumeration.ONE.equals(InClass.Enumeration.ONE): " + (Enumeration.ONE.equals(InClass.Enumeration.ONE)));

        // in case there is no such enum instance exception is thrown.
        //enm = InClass.Enumeration.valueOf("SEVEN");
    }
}
