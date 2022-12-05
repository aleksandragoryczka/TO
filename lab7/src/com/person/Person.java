package com.person;

import com.Coordinates;
import com.name.IName;
import com.name.NameFactory;

public class Person implements IPerson{
    private IName name;
    private String surname;
    private Coordinates coordinates;


    @Override
    public IPerson createPerson(NameFactory nameFactory, String name, String surname, Coordinates coordinates) {
        this.name = nameFactory.getName(name);
        this.surname = surname;
        this.coordinates = coordinates;
        return this;
    }

    @Override
    public String getName() {
        return this.name.getName();
    }

    @Override
    public String getSurname() {
        return this.surname;
    }

    @Override
    public String getCoordinates() {
        return this.coordinates.toString();
    }
}
