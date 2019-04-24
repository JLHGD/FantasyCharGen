package Main;

import AttributeStuff.AttributeID;
import UserInterfaceItems.AttributeMenuButton;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

/**
 * @author Jasen Harper
 * Creates a button
 */
public class ButtonCreator {

    public AttributeMenuButton createButtonsWithAttributeID(GridPane gridpane, ArrayList<AttributeID> attributes, String defaultAttributeOutput, int gridColumnIndex, int gridRowIndex){


        // MENU BUTTON LISTS, will be disabled / enabled by check boxes and randomly gone through by the
        // random button
        AttributeMenuButton attributeList = new AttributeMenuButton(defaultAttributeOutput);

        attributeList.addAllMenuItems(attributes);
        attributeList.sortAttributeList();

        gridpane.add(attributeList, gridColumnIndex, gridRowIndex);

        return attributeList;

    }



    public AttributeMenuButton createButtonsWithString(GridPane gridpane, ArrayList<String> attributes, String defaultAttributeOutput, int gridColumnIndex, int gridRowIndex) {


        // MENU BUTTON LISTS, will be disabled / enabled by check boxes and randomly gone through by the
        // random button

        ArrayList<AttributeID> attributeMenuItems = new ArrayList<>();

        for(String attribute : attributes){
            String[] customParameter = {defaultAttributeOutput, attribute};
            attributeMenuItems.add(new AttributeID(customParameter));
        }

        AttributeMenuButton attributeList = new AttributeMenuButton(defaultAttributeOutput);

        attributeList.addAllMenuItems(attributeMenuItems);
        attributeList.sortAttributeList();

        gridpane.add(attributeList, gridColumnIndex, gridRowIndex);

        return attributeList;

    }

}
