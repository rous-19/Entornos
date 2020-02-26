package com.gmq.entornos.naming;

/**
 * Encuentra y corrige al menos las 10 incorrecciones de código en la siguiente clase
 */
public class naming_exercise {

    public String get_name() {
        return name;
    }

    private String getaddres() { return address; }

    static public  String names[];

    String name, address;

    void create_naming_instance (String name, String address)
    {
        names[0] = name;
    }
}