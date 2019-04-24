package Main;

import AttributeStuff.AttributeID;
import AttributeStuff.Attributes;
import AttributeStuff.SubAttributes;
import UserInterfaceItems.AttributeCheckBox;
import UserInterfaceItems.AttributeMenuButton;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Jasen Harper
 * The main app where all of the buttons are created and where all things buttons are handled
 */
public class MainApp extends Application{

    // Advanced stands for things that are not part of the player's handbook
    // Basic stands for things that are part of the player's handbook
    private Stage stage;
    private BorderPane borderpane;
    private GridPane gridpane;
    private double version;
    private Attributes attributes;
    private SubAttributes subAttributes;
    protected static ArrayList<AttributeID> advancedRaces;
    protected static ArrayList<AttributeID> basicRaces;
    protected static ArrayList<AttributeID> advancedClasses;
    protected static ArrayList<AttributeID> basicClasses;
    protected static ArrayList<String> sexes;
    protected static ArrayList<String> alignments;

    public MainApp(){
        this.attributes = new Attributes();
        this.subAttributes = new SubAttributes();
        advancedRaces = new ArrayList<>();
        basicRaces = new ArrayList<>();
        advancedClasses = new ArrayList<>();
        basicClasses = new ArrayList<>();
        sexes = new ArrayList<>();
        alignments = new ArrayList<>();
        advancedRaces.addAll(attributes.getRaces());
        basicRaces.addAll(attributes.getBasicRaces());
        advancedClasses.addAll(attributes.getClasses());
        basicClasses.addAll(attributes.getBasicClasses());
        sexes.addAll(subAttributes.getSexes());
        alignments.addAll(subAttributes.getAlignments());

        this.stage  = new Stage();
        this.borderpane = new BorderPane();
        this.gridpane = new GridPane();

        this.version = 0.1;
        borderpane.setCenter(gridpane);

    }

    public void start(Stage primaryStage) throws Exception {
        Random r = new Random();

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Scene scene = new Scene(borderpane);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // The grid pane is where all buttons, checkboxes, and lists will be held
        // all around random button
        // checkboxes for disabling and enabling items that you want randomly generated
        // lists of races, classes, etc. (maybe stats and armours/equipment as well)
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        ButtonCreator buttonCreator = new ButtonCreator();
        AttributeMenuButton raceList = buttonCreator.createButtonsWithAttributeID(this.gridpane, advancedRaces, "Races", 1, 1);
        raceList.addAllMenuItems(basicRaces);
        raceList.sortAttributeList();
        AttributeMenuButton classList = buttonCreator.createButtonsWithAttributeID(this.gridpane, advancedClasses, "Classes", 1, 2);
        classList.addAllMenuItems(basicClasses);
        classList.sortAttributeList();
        AttributeMenuButton sexList = buttonCreator.createButtonsWithString(this.gridpane, sexes, "Sexes", 1, 3);
        AttributeMenuButton alignList = buttonCreator.createButtonsWithString(this.gridpane, alignments, "Alignments", 1, 4);


        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        CheckBoxCreator disableCheckBox = new CheckBoxCreator();
        disableCheckBox.createCheckBoxes(this.gridpane, raceList, 0, 1);
        disableCheckBox.createCheckBoxes(this.gridpane, classList, 0, 2);
        disableCheckBox.createCheckBoxes(this.gridpane, sexList, 0, 3);
        disableCheckBox.createCheckBoxes(this.gridpane, alignList, 0, 4);


        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        AttributeCheckBox enableAdvancedRaces = disableCheckBox.createAttributeCheckBox(gridpane, raceList, advancedRaces, "Advanced Races", 2, 1);
        AttributeCheckBox enableBasicRaces = disableCheckBox.createAttributeCheckBox(gridpane, raceList, basicRaces, "Basic Races", 3, 1);
        AttributeCheckBox enableAdvancedClasses = disableCheckBox.createAttributeCheckBox(gridpane, classList, advancedClasses, "Advanced Classes", 2, 2);
        AttributeCheckBox enableBasicClasses = disableCheckBox.createAttributeCheckBox(gridpane, classList, basicClasses, "Basic Class", 3, 2);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        // RANDOM BUTTON, there will only be one of these
        Button randomButton = new Button("Random");
        AttributeMenuButton[] lists = {raceList, classList, sexList, alignList};
        //int itemIndex = -1;
        //EventHandler itemEventHandler = new EventHandler<ActionEvent>(){
            //private int index;
            //@Override
            //public void handle(ActionEvent e){
            //    disableMenuItemsRandomHelper(this.index, raceList, r);
            //    pickHelper(raceList, lists);
            //}
            //public int incrementitemIndex(int index){
            //    this.index = index;
            //    return index++;
            //}
        //};
        //for (MenuItem item : raceList.getItems()){
            //itemIndex = itemEventHandler.incrementitemIndex(itemIndex);
            //item.setOnAction(itemEventHandler);
            //item.setOnAction( e -> {
                //disableMenuItemsRandomHelper(itemIndex, raceList, r);
                //pickHelper(raceList, lists);
            //});
            //itemIndex++;
        //}
        randomButton.setOnAction(e -> {

            randomButtonReset(lists); // Resets lists if they are enabled before randomization

            // RANDOM FOR RACE LIST

            randomBasicAdvancedHelper(raceList, enableAdvancedRaces, enableBasicRaces, r, advancedRaces, basicRaces);

            // RANDOM FOR CLASS LIST

            randomBasicAdvancedHelper(classList, enableAdvancedClasses, enableBasicClasses, r, advancedClasses, basicClasses);

            // RANDOM FOR SEX LIST

            if(!sexList.isDisabled()){
                int index = r.nextInt(sexes.size());
                disableMenuItemsRandomHelper(index, sexList, r);
            }

            // RANDOM FOR ALIGNMENT LIST

            if(!alignList.isDisabled()){
                int index = r.nextInt(alignments.size());
                disableMenuItemsRandomHelper(index, alignList, r);

            }

        });
        gridpane.add(randomButton, 0, 0); // put at bottom


        gridpane.setVgap(20);
        gridpane.setHgap(10);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // borderpane will have a big text field for displaying a description
        // as well as a picture (get a default picture as well that will display with the
        // same size as the rest of the images)

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        stage.setScene(scene);

        // Change the version each time you roll out an update
        // (once you have the basics of it working, start updating the version)
        stage.setTitle("Fantasy Character Generator ver. " + version);
        stage.setMaxWidth(1600);
        stage.setMaxHeight(1000);
        stage.setMinHeight(500);
        stage.setMinWidth(800);
        stage.show();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    }


    //////////////////////////////////////////////////////////////////////// HELPER METHODS /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Checks if an item at a given index is disabled. If it is not disabled,
     * then the menu button will set its value to the item at the given index
     * @param index The index of the item being checked in the menu button list
     * @param list The menu button
     * @param r The random number generator
     */
    private void disableMenuItemsRandomHelper(int index, AttributeMenuButton list, Random r){
        boolean allDisabled = true;
        for(MenuItem id : list.getItems()){ // checks if all items in the given list are disabled
            if(!id.isDisable()){
                allDisabled = false;
            }
        }
        if(!allDisabled) { // if they are not all disabled, then check if the item at the index is disabled,
            // and if it is not disabled
            // then set the text to the item's name at the given index
            if (!list.getAttMenuItem(list.getItems().get(index).getText()).isDisable()) {
                list.setText(list.getItems().get(index).getText());
            }
            else { // Otherwise, give a new random index and repeat this method
                int newIndex = r.nextInt(list.getItems().size());
                disableMenuItemsRandomHelper(newIndex, list, r);
            }
        }
    }

    /**
     * Resets the lists if the random button is
     * @param lists An array of menu buttons that holds all of the menu buttons that need to be reset
     */
    private void randomButtonReset(AttributeMenuButton[] lists){
        for(AttributeMenuButton list : lists){
            if(!list.isDisabled()){
                list.resetToDefault();
            }
        }
    }

    /**
     * Sets the given menu button's value depending on if basic and/or advanced are enabled
     * @param list The menu button
     * @param enableAdvanced The check box for enabling/disabling advanced stuff
     * @param enableBasic The check box for enabling/disabling basic stuff
     * @param r The random number generator
     * @param advanced The advanced list of things
     * @param basic The basic list of things
     */
    private void randomBasicAdvancedHelper(AttributeMenuButton list,
                                           AttributeCheckBox enableAdvanced,
                                           AttributeCheckBox enableBasic,
                                           Random r,
                                           ArrayList<AttributeID> advanced,
                                           ArrayList<AttributeID> basic){
        if(!list.isDisabled()){ // If the menu button is enabled
            if(enableAdvanced.isEnabled() && enableBasic.isEnabled()) {
                // And the two checkboxes to enable
                // basic and advanced are checked
                int index = r.nextInt(advanced.size()+basic.size());
                // Set a random number that is the sum of the size of the arrays
                // Then set the current attribute and text to the item at a random index
                disableMenuItemsRandomHelper(index, list, r);
                list.setCurrentAttribute(list.getText());
            }
                // If only advanced things are enabled
            else if(enableAdvanced.isEnabled() && !enableBasic.isEnabled()) {
                // Only go up to the last index of the advanced list
                int index = r.nextInt(advanced.size());
                disableMenuItemsRandomHelper(index, list, r);
                list.setCurrentAttribute(list.getText());
            }
                // If only basic things are enabled
            else if(!enableAdvanced.isEnabled() && enableBasic.isEnabled()){
                // Only go up to the last index of the basic list
                int index = r.nextInt(basic.size());
                disableMenuItemsRandomHelper(index, list, r);
                list.setCurrentAttribute(list.getText());
            }
                // If neither are enabled
            else if(!enableAdvanced.isEnabled() && !enableBasic.isEnabled()){
                // Don't do anything
            }
        }
    }

    /**
     * Enables/disables menu button items in the lists depending on what is picked in other lists
     * @param targetList The list that is being changed
     * @param lists All other lists that are being affected
     */
    private void pickHelper(AttributeMenuButton targetList, AttributeMenuButton[] lists){
        ArrayList<AttributeID> ids = targetList.getAttributes();
        AttributeID currentID = targetList.getAttributes().get(0);
        for(AttributeID id : ids){
            if(targetList.getCurrentAttribute().equals(id.getName())){
                currentID = id;
            }
        }
        for(AttributeMenuButton list : lists){
            if(!list.equals(targetList)){
                for(MenuItem menuItem : list.getItems()){
                    for(AttributeID otherID : list.getAttributes()) {
                        if (menuItem.getText().equals(otherID.getName())) {
                            if(!otherID.getAlignment().equals("/") && !currentID.getAlignment().equals("/")) {
                                if(!otherID.getAlignment().split("\\s")[1].equals(currentID.getAlignment().split("\\s")[1])) { // for all good / neutral / evil
                                    menuItem.setDisable(true);
                                }
                                else{
                                    menuItem.setDisable(false);
                                }
                                if(!currentID.getAlignment().split("\\s")[0].equals("Any")){
                                    if(!otherID.getAlignment().split("\\s")[0].equals(currentID.getAlignment().split("\\s")[0])) { // for all chaotic / true / neutral / lawful
                                        menuItem.setDisable(true);
                                    }
                                    else{
                                        menuItem.setDisable(false);
                                    }
                                }
                            }
                            if(!currentID.getSex().equals("/")){
                                if(!otherID.getName().equals(currentID.getSex())){
                                    menuItem.setDisable(true);
                                }
                                else{
                                    menuItem.setDisable(false);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Sets the value of the menu button and disables all of the attributes that are incompatible with the selected
     */
    //public void MenuItemEventListenerHelper(){
        //disableMenuItemsRandomHelper(this.index, raceList, r);
        //pickHelper(raceList, lists);
    //}

}
