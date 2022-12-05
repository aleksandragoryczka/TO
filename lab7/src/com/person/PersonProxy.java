package com.person;

import com.Coordinates;
import com.name.NameFactory;

public class PersonProxy implements IPerson{

    private Person person;

    @Override
    public IPerson createPerson(NameFactory nameFactory, String name, String surname, Coordinates coordinates) {
        this.person = new Person();
        this.person.createPerson(nameFactory, capitalize(name), capitalize(surname), coordinates);
        return this.person;
    }

    @Override
    public String getName() {
        return person.getName();
    }

    @Override
    public String getSurname() {
        return person.getSurname();
    }

    @Override
    public String getCoordinates() {
        return person.getCoordinates();
    }

    private String capitalize(String word){
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }


}
