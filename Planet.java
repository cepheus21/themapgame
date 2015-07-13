package themapgame;

import java.util.ArrayList;

/**
 * Created by Eric on 7/12/2015.
 */
public class Planet {

    /*
        erzh's comments
        1. look up camelcase. It will help your code readability a lot.
        2. 'Type' can be represented as an enum within Planet. Also think about renaming 'Type' to 'biome'
        3. protect yo' shit. make most of those variables private or at least protected.
     */

    int ground_slots, ground_slotsfilled, space_slots, space_slotsfilled, production, research, espionage, diplomacy; //various building slots and other modifiers
    double money, trade_value;
    boolean trading; //whether or not the planet is connected to a trade network
    String Type; //the biome type of the planet
    boolean lab_spec_building, hq_spec_building, emb_spec_building, can_Build_Ships = false; //checker for headquarters, labs, embassies, and orbital shipyards, can only be one per planet
    String Name;
    Player owner;
    ArrayList<String> groundbuildings = new ArrayList<String>();
    ArrayList<String> spacebuildings = new ArrayList<String>();

    public Planet(String name, String type, Player owner) {
        Name = name;
        owner = owner;
        setType(type);
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player Owner) {
        owner = Owner;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        switch (type) {
            case "Archipelago":
                Type = "Archipelago";
                production = 5;
                ground_slots = 16;
                space_slots = 40;
                money = 12;
                break;
            case "Desert":
                Type = "Desert";
                production = 6;
                ground_slots = 20;
                space_slots = 40;
                money = 16;
                break;
            case "Eucemenopolis":
                Type = "Eucemenopolis";
                production = 20;
                ground_slots = 52;
                space_slots = 100;
                money = 300;
                break;
            case "Ice":
                Type = "Ice";
                production = 5;
                ground_slots = 10;
                space_slots = 40;
                money = 10;
                break;
            case "Ocean":
                Type = "Ocean";
                production = 6;
                ground_slots = 12;
                space_slots = 40;
                money = 10;
                break;
            case "Paradise":
                Type = "Paradise";
                production = 6;
                ground_slots = 20;
                space_slots = 40;
                money = 100;
                break;
            case "Terran":
                Type = "Terran";
                production = 8;
                ground_slots = 18;
                space_slots = 40;
                money = 14;
                break;
            case "Mountainous":
                Type = "Mountainous";
                production = 10;
                ground_slots = 26;
                space_slots = 40;
                money = 22;
                break;
            case "Forest":
                Type = "Forest";
                production = 10;
                ground_slots = 17;
                space_slots = 40;
                money = 13;
                break;
            case "Volcanic":
                Type = "Volcanic";
                production = 15;
                ground_slots = 20;
                space_slots = 40;
                money = 16;
                break;
        }
    }

    public double getMoney() {
        return money;
    }

    public double getProd() {
        return production;
    }

    public void getSlots() {
        System.out.println(this.ground_slotsfilled + " ground slots filled out of " + this.ground_slots);
        System.out.println(this.space_slotsfilled + " space slots filled out of " + this.space_slots + "\n");
    }

    public void printInfo() {
        System.out.println("Planet Name: " + this.getName());
        System.out.println("Planet Type: " + this.getType());
        System.out.println("Money: " + this.getMoney());
        System.out.println("Production: " + this.getProd());
        System.out.println("Owner: " + this.getOwner());
        System.out.print("Buildings: ");
        for (int i = 0; i < groundbuildings.size(); i++)
            System.out.print(groundbuildings.get(i) + "   ");
        for (int i = 0; i < spacebuildings.size(); i++)
            System.out.println(spacebuildings.get(i) + "  ");
        this.getSlots();
    }

    public void addBuilding(String building) { //adding a building to a planet's production network
        if (building == "Mine") {
            if (this.ground_slotsfilled < (this.ground_slots - 2)) {
                this.production += 2;
                this.ground_slotsfilled += 2;
                owner.player_production -= 1;
                groundbuildings.add("Mine");
                System.out.println("A Mine has been constructed on " + this.getName());
            }
        } else if (building == "Factory") {
            if (this.ground_slotsfilled < (this.ground_slots - 4)) {
                this.production += 5;
                this.ground_slotsfilled += 4;
                owner.player_production -= 2;
                groundbuildings.add("Factory");
                System.out.println("A Factory has been constructed on " + this.getName());
            }
        } else if (building == "Laboratory") {
            if (this.ground_slotsfilled < this.ground_slots - 3) {
                if (lab_spec_building == false) {
                    this.research += 5;
                    this.ground_slotsfilled += 3;
                    owner.player_production -= 2;
                    this.lab_spec_building = true;
                    groundbuildings.add("Laboratory");
                    System.out.println("A Laboratory has been constructed on " + this.getName());
                }
            }
        } else if (building == "Bank") {
            if (this.ground_slotsfilled < (this.ground_slots - 4)) {
                this.money *= 1.01;
                this.ground_slotsfilled += 4;
                owner.player_production -= 6;
                groundbuildings.add("Bank");
                System.out.println("A Bank has been constructed on " + this.getName());
            }
        } else if (building == "Embassy") {
            if (this.ground_slotsfilled < (this.ground_slots - 3)) {
                if (emb_spec_building == false) {
                    owner.player_diplomacy += 5;
                    ground_slotsfilled += 3;
                    owner.player_production -= 5;
                    this.emb_spec_building = true;
                    groundbuildings.add("Embassy");
                    System.out.println("An Embasssy has been constructed on " + this.getName());
                }
            }
        } else if (building == "Headquarters") {
            if (this.ground_slotsfilled < (this.ground_slots - 4) && this.hq_spec_building == false) {
                owner.player_espionage += 5;
                this.ground_slotsfilled += 4;
                owner.player_production -= 7;
                this.hq_spec_building = true;
                groundbuildings.add("Headquarters");
                System.out.println("A Headquarters has been constructed on " + this.getName());
            }
        } else if (building == "Orbital Shipyard") {
            if (this.space_slotsfilled < this.space_slots - 10) {
                production += 10;
                owner.player_production -= 6;
                this.can_Build_Ships = true;
                this.space_slotsfilled += 10;
                spacebuildings.add("Orbital Shipyard");
                System.out.println("An Orbital Shipyard has been constructed on " + this.getName());
            }
        } else if (building == "Orbital Mining") {
            if (this.space_slotsfilled < this.space_slots - 5) {
                production += 5;
                owner.player_production -= 3;
                this.space_slotsfilled += 5;
                spacebuildings.add("Orbital Mining");
                System.out.println("An Orbital Mining Platform has been constructed on " + this.getName());
            }
        } else if (building == "Orbital Banking") {
            if (space_slotsfilled < this.space_slots - 4) {
                money *= 1.01;
                if (this.trading == true) {
                    trade_value += 0.5;
                    money += trade_value;
                    spacebuildings.add("Orbital Banking");
                    System.out.println("An Orbital Banking Platform has been constructed on " + this.getName());
                }
            }
        } else if (building == "Orbital Station") {
            if (this.space_slotsfilled < this.space_slots - 10) {
                this.trading = true;
                money += 2;
                this.space_slotsfilled += 10;
                spacebuildings.add("Orbital Station");
                System.out.println("An Orbital Trading Station has been constructed on " + this.getName());
            }
        }
    }
}