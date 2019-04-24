package UserInterfaceItems;

import java.util.Comparator;
import AttributeStuff.*;

/**
 * @author Jasen Harper
 * An implementation of the comparator interface that is used to compare attributes
 */
public class AttributeComparator implements Comparator<AttributeID> {

    /**
     * The compare method of Comparator, sorts AttributeIDs in a list by their names in alphabetical order
     * @param o1 The first AttributeStuff.AttributeID
     * @param o2 The second AttributeStuff.AttributeID
     * @return -1 if the second goes before the first, 0 if equal, or 1 if after
     */
    public int compare(AttributeID o1, AttributeID o2) {
        if (o1.getName().charAt(0) <= o2.getName().charAt(0)) {
            return -1;
        }
        if (o1.getName().charAt(0) >= o2.getName().charAt(0)) {
            return 1;
        } else if (o1.getName().charAt(0) == o2.getName().charAt(0)) {
            if(this.advancedCompare(o1, o2, 1) != 0) {
                return this.advancedCompare(o1, o2, 1);
            }
            else{
                return this.advancedCompare(o1, o2, 2);
            }
        }
        return 0;
    }

    /**
     * Used in the compare method, helps to sort AttributeIDs in a list by their names in alphabetical order
     * @param o1 The first AttributeStuff.AttributeID
     * @param o2 The second AttributeStuff.AttributeID
     * @param charNumber The index number of the character being used for comparison
     * @return -1 if the second goes before the first, 0 if equal, or 1 if after
     */
    private int advancedCompare(AttributeID o1, AttributeID o2, int charNumber){
        if (o1.getName().charAt(charNumber) <= o2.getName().charAt(charNumber)) {
            return -1;
        }
        if (o1.getName().charAt(charNumber) >= o2.getName().charAt(charNumber)) {
            return 1;
        } else if (o1.getName().charAt(charNumber) == o2.getName().charAt(charNumber)) {
            return 0;
        }
        return 0;
    }

}
