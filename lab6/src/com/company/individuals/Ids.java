package com.company.individuals;

public class Ids {
    private static int idCounter = 0;

    public static int createID(){
        return idCounter++;
    }
}
