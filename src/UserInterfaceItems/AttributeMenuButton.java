package UserInterfaceItems;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import AttributeStuff.*;

import java.util.ArrayList;

/**
 * @author Jasen Harper
 * An extension of the Menu Button class in the Javafx library that is built for taking care of all things attributes
 */
public class AttributeMenuButton extends MenuButton{

    private String currentAttribute = "";
    private String defaultAttribute = "";
    private ArrayList<AttributeID> attributes;

    public AttributeMenuButton(String defaultName){
        super(defaultName);
        this.attributes = new ArrayList<>();
        this.defaultAttribute = defaultName;
    }

    public AttributeMenuButton(){
        this.attributes = new ArrayList<>();
    }

    public String getCurrentAttribute(){
        return currentAttribute;
    }

    public void setCurrentAttribute(String s){
        currentAttribute = s;
    }

    public AttributeMenuItem getAttMenuItem(String name){
        for(MenuItem mi  : this.getItems()){
            if(mi instanceof  AttributeMenuItem){
                AttributeMenuItem ami = (AttributeMenuItem)mi;
                if(ami.getAttName().equals(name)){
                    return ami;
                }
            }
        }
        return null;
    }

    /**
     * Adds all items from an Array List to the attribute menu button
     * @param al The array list being added
     */
    public void addAllMenuItems(ArrayList<AttributeID> al){
        for(AttributeID alitem : al) {
            AttributeMenuItem item = new AttributeMenuItem(alitem.getName());
            item.setOnAction(e -> {
                this.setCurrentAttribute(alitem.getName());
                this.setText(alitem.getName());
            });
            this.getItems().add(item);
            attributes.add(alitem);
        }
    }

    /**
     * Removes all items from the menu from the array list
     * @param al The array list being removed
     */
    public void removeAllMenuItems(ArrayList<AttributeID> al){
        for(AttributeID id : al){
            if(this.attributes.contains(id)){
                this.attributes.remove(id);
                this.getItems().remove(this.getAttMenuItem(id.getName()));
            }
        }
    }

    /**
     * Sorts the internal list in the menu button
     */
    public void sortAttributeList(){
        AttributeComparator ac = new AttributeComparator();
        AttributeMenuItemComparator amic = new AttributeMenuItemComparator();
        this.attributes.sort(ac);
        this.getItems().sort(amic);
        //for(AttributeStuff.AttributeID aid : attributes) {
            //System.out.println(aid.getName());
        //}
    }

    public ArrayList<AttributeID> getAttributes() {
        return attributes;
    }

    /**
     * Sets the current value of the menu button to a default value which depends on what the list is
     */
    public void resetToDefault(){
        this.setCurrentAttribute(defaultAttribute);
        this.setText(defaultAttribute);
    }
}
