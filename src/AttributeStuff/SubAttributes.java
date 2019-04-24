package AttributeStuff;

import java.util.ArrayList;

/**
 * @author Jasen Harper
 * All of the attributes of a character, will later be moved to an SQL file
 */
public class SubAttributes {


    private static ArrayList<String> subatsexes;
    private static ArrayList<String> subatalign;


    public SubAttributes(){
        subatsexes = new ArrayList<>();
        subatalign = new ArrayList<>();
        this.createSexes();
        this.createAlignments();
    }


    private void createSexes(){
        subatsexes.add("Other");
        subatsexes.add("Female");
        subatsexes.add("Male");
    }


    private void createAlignments(){
        subatalign.add("Chaotic Evil");
        subatalign.add("Neutral Evil");
        subatalign.add("Lawful Evil");
        subatalign.add("Chaotic Neutral");
        subatalign.add("True Neutral");
        subatalign.add("Lawful Neutral");
        subatalign.add("Chaotic Good");
        subatalign.add("Neutral Good");
        subatalign.add("Lawful Good");
    }


    public ArrayList<String> getSexes(){
        return subatsexes;
    }
    public ArrayList<String> getAlignments() {return subatalign; }

}
