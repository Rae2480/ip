package viktor.commands;

import viktor.ui.UI;


/**
 * Command to handle the goodbye message when the program ends.
 */
public class ByeCommand implements Commandable {
    /**
     * Executes the command to display a goodbye message.
     * 
     * Prints a farewell message to the user when the program is about to end.
     */
    @Override
    public void execute() {
        System.out.println(UI.CURLY_START + "Goodbye. Remember, progress never rests." + UI.CURLY_END);
    }
}
