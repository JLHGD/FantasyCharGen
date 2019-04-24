package Main;

import AttributeStuff.AttributeID;
import UserInterfaceItems.AttributeCheckBox;
import UserInterfaceItems.AttributeMenuButton;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

/**
 * @author Jasen Harper
 * Creates a check box
 */
public class CheckBoxCreator {

    public void createCheckBoxes(GridPane gridpane, AttributeMenuButton attributeList, int gridColumnIndex, int gridRowIndex){
        // CHECK BOXES, these disable / enable the lists from being randomized and/or selected
        // However, they are still read by the text field
        CheckBox checkBox = new CheckBox();
        checkBox.setSelected(true);
        checkBox.setOnAction(e -> {
            if(!attributeList.isDisabled()) {
                attributeList.setDisable(true);
            }
            else{
                attributeList.setDisable(false);
            }
        });
        gridpane.add(checkBox, gridColumnIndex, gridRowIndex);
    }

    public AttributeCheckBox createAttributeCheckBox(GridPane gridpane, AttributeMenuButton attributeList, ArrayList<AttributeID> removeList, String name, int gridColumnIndex, int gridRowIndex){
        // CHECK BOXES, these disable/enable basic and advanced classes, races, etc.
        AttributeCheckBox checkBox = new AttributeCheckBox();
        checkBox.setText(name);
        checkBox.setEnabled(true);
        checkBox.setOnAction(e -> {
            if(checkBox.isEnabled()){
                checkBox.setEnabled(false);
                attributeList.removeAllMenuItems(removeList);
            }
            else {
                attributeList.addAllMenuItems(removeList);
                checkBox.setEnabled(true);
            }
            attributeList.sortAttributeList();
        });
        gridpane.add(checkBox, gridColumnIndex, gridRowIndex);
        return checkBox;
    }



}
