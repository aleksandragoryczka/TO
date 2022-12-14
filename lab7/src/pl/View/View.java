package pl.View;

import pl.Coordinates;
import pl.name.NameFactory;
import pl.person.IPerson;
import pl.person.Person;
import pl.person.PersonProxy;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class View {

    private final ArrayList<IPerson> persons = new ArrayList<>();
    private final NameFactory nameFactory = new NameFactory();



    public void show() {

        boolean exit = false;
        while(!exit){
            int choice = menu();
            if(choice == 1)
                addPerson();
            if(choice == 2)
                verifyPerson();
            if(choice==0)
                exit = true;
        }

    }

    private int menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("[0] WYJŚCIE");
        System.out.println("[1] Dodaj osobę");
        System.out.println("[2] Zweryfikuj osobę");
        return scanner.nextInt();
    }

    private void addPerson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPODAJ DANE NOWEJ OSOBY");
        System.out.print("Imię: ");
        String name = scanner.nextLine();
        System.out.print("Nazwisko: ");
        String surname = scanner.nextLine();
        System.out.println("WSPÓŁRZĘDNE GEOGRAFICZNE");
        System.out.print("X: ");
        double posX = Double.parseDouble(scanner.nextLine());
        System.out.print("Y: ");
        double posY = Double.parseDouble(scanner.nextLine());

        PersonProxy personProxy = new PersonProxy();
        Coordinates coordinates = new Coordinates(posX, posY);
        Person person = (Person) personProxy.createPerson(this.nameFactory, name, surname, coordinates);
        this.persons.add(person);
        System.out.println("Dodano");
    }

    private void verifyPerson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPODAJ DANE OSOBY");
        System.out.print("Imię: ");
        String name = scanner.nextLine();
        System.out.print("Nazwisko: ");
        String surname = scanner.nextLine();

        PersonProxy personProxy = new PersonProxy();
        Coordinates coordinates = new Coordinates(0,0);
        IPerson person = personProxy.createPerson(nameFactory, name, surname, coordinates);


        for (IPerson p : persons             )
        {
            if(Objects.equals(p.getName(), person.getName()) && Objects.equals(p.getSurname(), person.getSurname())){
                System.out.println(p.getName() + " " + p.getSurname() + "  " + p.getCoordinates());
                return;
            }
        }
        System.out.println("Taka ososba nie istnieje w bazie.");

    }

}
