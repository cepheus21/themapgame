package themapgame;

import java.util.ArrayList;

/**
 * Created by Eric on 7/12/2015.
 */
public class Ship {

    /*
        erzh's comments
        1. use an enum for ship types. See Oracle's page https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
        2. make your variables private
     */

    String name;
    String class_type;
    int length;
    int cost;
    int power;

    public Ship(String Name, String Class_type) {
        name = Name;
        setClass(Class_type);
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        name = Name;
    }

    public void setClass(String Class) {
        switch (Class) {
            case "Scout":
                class_type = "Scout";
                length = 50;
                cost = 10;
                power = 5;
                break;
            case "Cruiser":
                length = 250;
                class_type = "Cruiser";
                cost = 35;
                power = 25;
                break;
            case "Frigate":
                length = 400;
                class_type = "Frigate";
                cost = 50;
                power = 42;
                break;
            case "Carrier":
                length = 500;
                class_type = "Carrier";
                cost = 70;
                power = 50;
                break;
            case "Battleship":
                length = 750;
                class_type = "Battleship";
                cost = 65;
                power = 75;
                break;
            case "Dreadnought":
                length = 100;
                class_type = "Dreadnought";
                cost = 75;
                power = 90;
                break;
        }
    }

    public String getClassType() {
        return class_type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int Length) {
        length = Length;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int Cost) {
        cost = Cost;
    }

    public void addComplmement(int complement) {
        power += complement;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int Power) {
        power = Power;
    }


}