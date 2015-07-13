package themapgame;

import java.util.ArrayList;

/**
 * Created by Eric on 7/13/2015.
 */
public class Fleet {
    int number_of_ships, total_power;
    String fleet_name;
    ArrayList<Ship> fleet = new ArrayList<Ship>();

    public void addShip(Ship ship) {
        fleet.add(ship);
    }

    public void removeShip(Ship ship) {
        int placeholder = fleet.indexOf(ship);
        fleet.remove(placeholder);
    }

    public int getPower() {
        return total_power;
    }

    public String getName() {
        return fleet_name;
    }

    public void setName(String name) {
        fleet_name = name;
    }

    public void calcPower(ArrayList<Ship> ships) {
        for (int i = 0; i < ships.size(); i++) {
            total_power += ships.get(0).power;
        }

    }
}