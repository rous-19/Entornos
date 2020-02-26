package com.gmq.entornos.naming;

/**
 * Encuentra y corrige al menos las 10 incorrecciones de código en la siguiente clase
 */
public class NamingExercise { //rename the class

    //Field declarations after class definition

    //public static instead of static public
    //brakets in type not in variable name
    public static String[] names;

    //each field in one line
    String name;

    String address;

    //change method name
    public String getName() { //braces in different lines

        //you can add "this."
        return this.name;
    }

    //change method name
    private String getAddress() { //braces in different lines

        //you can add "this."
        return this.address;
    }

    //change method name
    //you can add an access modifier
    //you can remove address argument
    public void createNamingInstance (String name) { //braces in different lines

        names[0] = name;
    }
}
