/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicles;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Mantikor81
 */
public class MainApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean ende = false;
        int menue;
        Scanner eingabe = new Scanner(System.in);

        List<Car> carlist = new ArrayList<>();

        // HashSet zeigt bei Gleichheit nur ein Fahrzeug
        //HashSet<Car> hashCar = new HashSet<>();
        //hashCar.add(new Car());
        //hashCar.add(new Car());
        //System.out.println("Das HashSet enthält: "+ hashCar.size());
        System.out.println("Das Programm kann durch Eingabe der Zahl für die entsprechende Menüpunkte benutzt werden");
        while (!ende) {
            System.out.println(" ");
            System.out.println("_________________________________________________________________________________________________________________");
            System.out.println(" ");
            System.out.println("0 - Programm beenden | 1 - neues Fahrzeug anlegen | 2 -  bestimmtes Fahrzeug löschen | 3 - alle Fahrzeuge löschen");
            System.out.println("4 - Liste der Fahrzeuge anzeigen | 5 - Liste der Fahrzeuge in Datei | 6 - Fahrzeug benutzen");
            System.out.println("7 - Liste der Fahrzeuge nach km Sortieren");
            System.out.println("_________________________________________________________________________________________________________________");
            System.out.println(" ");
            System.out.print("Menue-Punkt: ");
            menue = eingabe.nextInt();
            System.out.println(" ");
            switch (menue) {
                case 0:
                    ende = true;
                    break;
                case 1:
                    carlist.add(new Car());
                    System.out.println(" ");
                    System.out.println("Das Fahrzeug wurde angelegt!");
                    break;
                case 2:
                    System.out.print("Welches Fahrzeug ( Index-Nr.)soll gelöscht werden? ");
                    int index;
                    index = eingabe.nextInt();
                    carlist.remove(index);
                    break;
                case 3:
                    System.out.println("Wollen Sie wirklich alle Fahrzeuge löschen? JA/NEIN ");
                    System.out.print("Anwort: ");
                    String antwort = eingabe.next();
                    if (antwort == "JA") {
                        carlist.clear();
                        break;
                    } else {
                        break;
                    }
                case 4:
                    for (Car element : carlist) {
                        System.out.println(element);
                    }
                    break;
                case 5:
                    PrintWriter output = null;
                    try {
                        output = new PrintWriter(new FileWriter("Cars.txt"));
                        for (Car element : carlist) {
                            output.println(element);
                        }
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    } finally {
                        if (output != null) {
                            output.close();
                        }
                    }
                    break;
                case 6:
                    for (Car element : carlist) {
                        System.out.print(element + " | ");
                        System.out.println(" ");
                    }
                    System.out.print("Fahrzeug: ");
                    int carIndex = eingabe.nextInt();
                    Car Fahrzeug = carlist.get(carIndex);
                    boolean endeNutzung = false;
                    while (!endeNutzung) {
                        System.out.println("_____________________________________________________________________________________");
                        System.out.println(" ");
                        System.out.println("0 - Nutzung beenden | 1 - Motor starten | 2 -  Motor ausmachen | 3 - Fahrzeug bewegen");
                        System.out.println("4 - Fahrzeug tanken");
                        System.out.println("_____________________________________________________________________________________");
                        System.out.println(" ");
                        System.out.print("Eingabe: ");
                        int nutzung = eingabe.nextInt();
                        switch (nutzung) {
                            case 0:
                                endeNutzung = true;
                                break;
                            case 1:
                                Fahrzeug.startEngine();
                                break;
                            case 2:
                                Fahrzeug.stopEngine();
                                break;
                            case 3:
                                System.out.print("gefahrene Kilometer: ");
                                int entfernung = eingabe.nextInt();
                                Fahrzeug.move(entfernung);
                                break;
                            case 4:
                                Fahrzeug.tanken();
                                break;
                        }
                    }
                    break;
                case 7:
                    TreeSet<Car> CarSort = new TreeSet<>();
                    for (Car element : carlist) {
                        CarSort.add(element);

                    }
                    System.out.println(CarSort);
                    break;
            }

        }
    }

}
