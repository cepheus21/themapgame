package themapgame;

import java.util.ArrayList;

public class Player {

    /*
        erzh's comments:
        1. This class for the most part looks pretty solid in terms of organization.
     */




    static int player_diplomacy;
    static int player_espionage;
    static double player_production;
    static double econ_to_prod = 2;
    String Nation_name;
    String Player_name;
    double bank;
    int trade;
    int research;
    boolean trading = false;
    ArrayList<Ship> fleets = new ArrayList<>();
    ArrayList<Ship> ship_classes = new ArrayList<>();
    boolean at_war = false;
    ArrayList<Planet> planets = new ArrayList<Planet>();





    public Player(String n_name, String p_name, int credits, int prod) { //constructor
        Nation_name = n_name;
        Player_name = p_name;
        bank = credits;
        player_production = prod;
    }

    public void addPlanet(Planet planet) {
        planets.add(planet);
        planet.setOwner(this);
    }

    public void removePlanet(Planet planet) {
        int placeholder = planets.indexOf(planet);
        planets.remove(placeholder);
    }

    public String getPName() {
        return Player_name;
    }

    public void setPName(String name) {
        Player_name = name;
    }

    public String getNName() {
        return Nation_name;
    }

    public void setNName(String name) {
        Nation_name = name;
    }

    public void addBank(double money) {
        bank += money;
    }

    public void subtractBank(double money) {
        bank -= money;
    }

    public double getBank() {
        return bank;
    }

    public void addProd(double prod) {
        player_production += prod;
    }

    public void subtractProd(double prod) {
        player_production -= prod;
    }

    public double getProd() {
        return player_production;
    }

    public double getTotal(double prod, double money) {
        double total_spendable = prod + money * econ_to_prod;
        return total_spendable;
    }

    public void printInfo() {
        System.out.println("Player name: " + this.getPName());
        System.out.println("Nation name: " + this.getNName());
        System.out.println("Number of planets: " + planets.size());
        System.out.println("Money: " + getBank());
        System.out.println("Production: " + getProd());
        if (fleets.size() == 1)
            System.out.println("Number of ships: " + fleets.size() + " ship.");
        else
            System.out.println("Number of ships: " + fleets.size() + " ships.");
        System.out.println("Total Spendable Production: " + getTotal(getProd(), getBank()) + "\n");

    }

    public void makeBuilding(Planet planet, String building) {
        planet.addBuilding(building);
    }

    public void generateEconomy() {
        double credits = 0;
        double prod = 0;
        for (int i = 0; i < planets.size(); i++) {
            credits += planets.get(i).getMoney();
            prod += planets.get(i).getProd();
        }
        this.addBank(credits);
        this.addProd(prod);
    }

    public void makeShipClass(String Name, String Class_type) {
        ship_classes.add(new Ship(Name, Class_type)); //how to dynamically make objects based on input?
        System.out.println("Ship class " + ship_classes.get(0).getClassType() + " has been designed.");
    }

    public void makeShip(Ship ship, Planet planet) {
        player_production -= ship.getCost();
        fleets.add(ship);
        System.out.println("A " + ship.getName() + " class ship has been constructed on " + planet.getName() + ".");
    }




}
