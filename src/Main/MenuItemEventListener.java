package Main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * @author Jasen Harper
 * An event listener that is used to disable all other attributes that are not
 * compatible with the currently selected attributes
 */
public class MenuItemEventListener implements EventHandler<ActionEvent> {

    private int index;
    @Override
    public void handle(ActionEvent e){
        //disableMenuItemsRandomHelper(this.index, raceList, r);
        //pickHelper(raceList, lists);
    }
    public int incrementitemIndex(int index){
        this.index = index;
        return index++;
    }

}
