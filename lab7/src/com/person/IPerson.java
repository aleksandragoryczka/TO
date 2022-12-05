package com.person;

import com.Coordinates;
import com.name.NameFactory;

public interface IPerson {
    IPerson createPerson(NameFactory nameFactory, String name, String surname, Coordinates coordinates);

    String getName();
    String getSurname();
    String getCoordinates();

}
