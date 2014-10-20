/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicles;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Mantikor81
 */
public class Car implements Vehicles {

    Scanner eingabe = new Scanner(System.in);

    public boolean engineStatus = false;           // Motor-Status
    public String Kennzeichen;                     // Kennzeichen des Autos
    public String Marke;                           // Hersteller
    public String Typ;                             // Typenname des Fahrzeugs
    public int kmStand;                            // kmStand des Autos
    public float Benzintank;                       // Tankgröße in L
    public float Verbrauch;                        // Verbrauch in L auf 100km
    public int kmOhneTanken;                       // km ohne Tanken
    public int FahrzeugID;
    public float verbrauchtesBenzin;
    public float getankt;
   
    Car() {
        this.Kennzeichen = getKennzeichen();
        this.Marke = getMarke();
        this.Typ = getTyp();
        this.FahrzeugID = hashCode();
        this.Benzintank = 50F;
        this.Verbrauch = 5.5F;
        this.kmStand = 0;
        this.kmOhneTanken = 0;
        this.verbrauchtesBenzin = 0F;
        
    }

    @Override
    public int hashCode() {
        Random rn = new Random();
        int hash = 5;
        hash = hash * 5 + Marke.hashCode();
        hash = hash * 5 + Typ.hashCode();
        hash = hash * rn.nextInt(20) + rn.nextInt(100);

        return hash;
    }

    @Override
    public String toString() {
        return (this.Kennzeichen + " " + this.Marke + " " + this.Typ + " "+ this.FahrzeugID+" "+ this.Benzintank+" "+this.Verbrauch+
                " "+this.kmStand+" "+this.kmOhneTanken+" "+this.verbrauchtesBenzin);
    }
    
    @Override
    public boolean equals(Object obj) {
 
  if (obj == null) {
    return false;
  }
  if (obj == this) {
    return true;
  }
  if (obj.getClass() == this.getClass()) {
    Car b = (Car)obj;
    if (this.Kennzeichen == b.getKennzeichen()) {
      return true;
    }
  }
  return false;
}
    
    @Override
    public void startEngine() {
        if (!engineStatus) {
            this.engineStatus = true;
        } else {
            System.out.println("Der Motor ist bereits an!");
        }
    }

    @Override
    public void stopEngine() {
        if (engineStatus) {
            this.engineStatus = false;
        } else {
            System.out.println("Der Motor ist bereits aus!");
        }
    }

    @Override
    public void move(int distance) {
        if (this.engineStatus) {
            if ( (this.verbrauchtesBenzin + (this.Verbrauch*distance/100) ) < this.Benzintank){
            this.kmStand += distance;
            this.verbrauchtesBenzin += this.Verbrauch * distance / 100;
            this.kmOhneTanken += distance;
            }
            else {
                System.out.println("Sie haben nicht mehr genug Benzin für diese Fahrt! ");
                System.out.println("Sie sollten das Fahrzeug wieder volltanken! ");        
            }
        }
        else {
            System.out.println("Der Motor ist noch nicht an!");
        }
    }

    private String getKennzeichen() {
        try {
            System.out.print("Wunsch-Kennzeichen: ");
            Kennzeichen = eingabe.next();

        } catch (Exception e) {
            System.out.print("Dies ist kein Kennzeichen!");
        }
        return Kennzeichen;
    }

    private String getMarke() {
        try {
            System.out.print("Auto-Marke: ");
            Marke = eingabe.next();

        } catch (Exception e) {
            System.out.print("Dies ist keine Auto-Marke!");
        }
        return Marke;
    }

    private String getTyp() {
        try {
            System.out.print("Auto-Typ: ");
            Typ = eingabe.next();

        } catch (Exception e) {
            System.out.print("Dies ist kein Auto-Typ!");
        }
        return Typ;
    }
    
    public void tanken() {
        if(!engineStatus) {
           System.out.println("Das Fahrzeug wird vollgetankt");
           this.getankt = this.verbrauchtesBenzin;
           this.verbrauchtesBenzin = 0F;
           this.kmOhneTanken = 0;
           System.out.println("Es wurden " + this.getankt +" L getankt!" );
           System.out.println("Gesamtkilometer: "+ this.kmStand+ " | Mit der neuen Tankfüllung wurden bisher "+this.kmOhneTanken+" km gefahren.");
        }
        else {
            System.out.println("Für das Tanken bitte vorher noch den Motor abstellen!");
        }
    }
}
