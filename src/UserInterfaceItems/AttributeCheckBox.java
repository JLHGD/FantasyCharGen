package UserInterfaceItems;

import javafx.scene.control.CheckBox;

public class AttributeCheckBox extends CheckBox{

    private boolean enabled;

    /**
     * @author Jasen Harper
     * An extension of the Javafx check box that is built for handling attributes
     */
    public AttributeCheckBox(){
        this.enabled = true;
        this.setSelected(true);
    }

    public boolean isEnabled(){
        return enabled;
    }

    public void setEnabled(boolean b){
        this.enabled = b;
    }

}
