package UserInterfaceItems;

import javafx.scene.control.MenuItem;

/**
 * @author Jasen Harper
 * An extention on the Javafx Menu Item that is built for dealing with attributes
 */
public class AttributeMenuItem extends MenuItem {

    private String name;

    public AttributeMenuItem(String newName){
        super(newName);
        this.name = newName;
    }

    public String getAttName(){
        return this.name;
    }
}
