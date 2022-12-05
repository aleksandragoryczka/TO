package com.company;

import com.company.gui.MainWindow;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        int option, width=200, height=200, individualsNumbers=500;
        boolean immune=false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("[1] Wygeneruj symulację w przykładowych warunkach (szerokość: 200, wysokość: 200, liczba osobników: 500, brak oporności)");
        System.out.println("[2] Podaj własne warunki symulacji");
        System.out.print("Twój wybór: ");
        option = scanner.nextInt();
        if(option == 1){
            new MainWindow(width,height,individualsNumbers,immune);
        }
        if(option==2){
            System.out.println("Podaj szerokość okna symulacji: ");
            width=scanner.nextInt();
            System.out.println("Podaj wysokość okna symulacji: ");
            height=scanner.nextInt();
            System.out.println("Podaj liczbę osobników:");
            individualsNumbers=scanner.nextInt();
            System.out.println("Brak odporności populacji {true} / Populacja częściowo odporna {false}: ");
            immune= scanner.nextBoolean();

            new MainWindow(width,height,individualsNumbers,immune);
        }else{
            System.out.println("\nPodano nieporpawną opcję.");
        }
    }
}
