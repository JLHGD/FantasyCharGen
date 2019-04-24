package AttributeStuff;

import java.util.ArrayList;

/**
 * @author Jasen Harper
 * All of the attributes of a character, will later be moved to an SQL file
 */
public class Attributes {
    private static ArrayList<AttributeID> atraces;
    private static ArrayList<AttributeID> atbasicraces;
    private static ArrayList<AttributeID> atclasses;
    private static ArrayList<AttributeID> atbasicclasses;

    // ADD A FILTER FOR RACES (IN TERMS OF ALIGNMENT / SEX / ETC.)

    public Attributes(){
        atraces = new ArrayList<>();
        atbasicraces = new ArrayList<>();
        atclasses = new ArrayList<>();
        atbasicclasses = new ArrayList<>();
        this.createRaceList(atraces);
        this.createBasicRaceList(atbasicraces);
        this.createClassList(atclasses);
        this.createBasicClassList(atbasicclasses);
    }

    private void createRaceList(ArrayList<AttributeID> a){
        a.add(new AttributeID("Troglodyte", "Chaotic Evil", "/", "M"));
        a.add(new AttributeID("Lizardman", "Any Neutral", "/", "M"));
        a.add(new AttributeID("Aarakocra", "Neutral Good", "/", "M"));
        a.add(new AttributeID("Angel (Deva)", "Lawful Good", "/", "M"));
        a.add(new AttributeID("Angel (Planetar)", "Lawful Good", "/", "L"));
        a.add(new AttributeID("Angel (Solar)", "Lawful Good", "/", "L"));
        a.add(new AttributeID("Animated Object (Armor)", "/", "/", "/"));
        a.add(new AttributeID("Golem (Flesh)", "/", "/", "/"));
        a.add(new AttributeID("Golem (Metal)", "/", "/", "/"));
        a.add(new AttributeID("Golem (Wood)", "/", "/", "/"));
        a.add(new AttributeID("Golem (Clay)", "/", "/", "/"));
        a.add(new AttributeID("Golem (Stone)", "/", "/", "/"));
        a.add(new AttributeID("Golem (Dirt)", "/", "/", "/"));
        a.add(new AttributeID("Golem (Beat)", "Lawful Beat", "Beat", "/"));
        a.add(new AttributeID("Azer", "Lawful Neutral", "/", "M"));
        a.add(new AttributeID("Banshee", "Chaotic Neutral", "F", "M"));
        a.add(new AttributeID("Blight (Needle)", "Neutral Evil", "/", "M"));
        a.add(new AttributeID("Blight (Twig)", "Neutral Evil", "/", "S"));
        a.add(new AttributeID("Blight (Vine)", "Neutral Evil", "/", "M"));
        a.add(new AttributeID("Bugbear", "Chaotic Evil", "/", "M"));
        a.add(new AttributeID("Bullywug", "Neutral Evil", "/", "M"));
        a.add(new AttributeID("Cambion", "Any Evil", "/", "M"));
        a.add(new AttributeID("Centaur", "Neutral Good", "/", "L"));
        a.add(new AttributeID("Cyclops", "Chaotic Neutral", "/", "H"));
        a.add(new AttributeID("Death Knight", "Chaotic Evil", "/", "M"));
        a.add(new AttributeID("Demon (Balor)", "Chaotic Evil", "/", "H"));
    }

    private void createBasicRaceList(ArrayList<AttributeID> a){
        a.add(new AttributeID("Orc", "/", "/", "/"));
        a.add(new AttributeID("Elf", "/", "/", "/"));
        a.add(new AttributeID("Human", "/", "/", "/"));
        a.add(new AttributeID("Gnome", "/", "/", "/"));
        a.add(new AttributeID("Halfling", "/", "/", "/"));
        a.add(new AttributeID("Half-Orc", "/", "/", "/"));
        a.add(new AttributeID("Half-Elf", "/", "/", "/"));
        a.add(new AttributeID("Tiefling", "/", "/", "/"));
        a.add(new AttributeID("Dragonborn", "/", "/", "/"));
        a.add(new AttributeID("Dwarf", "/", "/", "/"));
    }

    private void createBasicClassList(ArrayList<AttributeID> a){
        a.add(new AttributeID("Barbarian", "/"));
        a.add(new AttributeID("Bard", "/"));
        a.add(new AttributeID("Cleric", "/"));
        a.add(new AttributeID("Druid", "/"));
        a.add(new AttributeID("Fighter", "/"));
        a.add(new AttributeID("Monk", "/"));
        a.add(new AttributeID("Paladin", "Any Good"));
        a.add(new AttributeID("Ranger", "/"));
        a.add(new AttributeID("Rogue", "/"));
        a.add(new AttributeID("Sorcerer", "/"));
        a.add(new AttributeID("Warlock", "/"));
        a.add(new AttributeID("Wizard", "/"));
    }

    private void createClassList(ArrayList<AttributeID> a){
        a.add(new AttributeID("Eldritch Knight", "/"));
        a.add(new AttributeID("Battle Master", "/"));
        a.add(new AttributeID("Champion", "/"));
    }

    public ArrayList<AttributeID> getRaces(){
        return atraces;
    }

    public ArrayList<AttributeID> getBasicRaces(){
        return atbasicraces;
    }

    public ArrayList<AttributeID> getClasses() {
        return atclasses;
    }

    public ArrayList<AttributeID> getBasicClasses() {
        return atbasicclasses;
    }

}
