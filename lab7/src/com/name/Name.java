package com.name;

public class Name implements IName{
    private String name;

    public Name(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
