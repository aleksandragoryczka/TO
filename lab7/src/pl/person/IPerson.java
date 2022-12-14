package pl.person;

import pl.Coordinates;
import pl.name.NameFactory;

public interface IPerson {
    IPerson createPerson(NameFactory nameFactory, String name, String surname, Coordinates coordinates);

    String getName();
    String getSurname();
    String getCoordinates();

}
