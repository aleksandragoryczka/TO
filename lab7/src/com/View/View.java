package com.View;

import com.Coordinates;
import com.name.NameFactory;
import com.person.IPerson;
import com.person.Person;
import com.person.PersonProxy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

    private ArrayList<IPerson> persons = new ArrayList<IPerson>();
    private NameFactory nameFactory = new NameFactory();



    public void show() throws IOException {
        FileWriter fileWriter = new FileWriter("names.txt");

        boolean exit = false;
        while(!exit){
            int choice = menu();
            if(choice == 1)
                addPerson(fileWriter);
            if(choice == 2)
                verifyPerson();
        }


        fileWriter.write("");
    }

    private int menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("[0] WYJŚCIE");
        System.out.println("[1] Dodaj osobę");
        System.out.println("[2] Zweryfikuj osobę");
        int option = scanner.nextInt();
        return option;
    }

    private void addPerson(FileWriter fileWriter){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPODAJ DANE NOWEJOSOBY");
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
        System.out.println("\nPODAJ DANE OSOBY");
        System.out.print("Imię: ");
    }




    public ArrayList<IPerson> getPersons() {
        return persons;
    }
}
