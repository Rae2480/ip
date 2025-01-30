import java.io.IOException;
import java.util.ArrayList;

public class Viktor {

    private UI ui;
    private TaskList taskList;
    private Parser parser;

    public Viktor() {
        ui = new UI();
        taskList = new TaskList();
        parser = new Parser();
    }

    public void start() {
        String userInput;
        ui.showWelcomeMessage();

        try {
            ArrayList<Task> loadedTasks = Storage.load(); 
            taskList.setTasks(loadedTasks); 
        } catch (IOException e) {
            System.out.println("Are you ready to put science first and put yourself to the text?");
        }

        while (true) {
            userInput = ui.readCommand();
            try {
                Commandable command = parser.parse(userInput, taskList, true); 
                command.execute();
                if (command instanceof ByeCommand) {
                    break; 
                }
            } catch (ViktorException e) {
                ui.showErrorMessage(e.getMessage());
            } catch (Exception e) {
                ui.showErrorMessage("Something went wrong! Very wrong! Hextech is alive!");
            }
        }

        ui.closeScanner();
    }

    public static void main(String[] args) {
        Viktor viktor = new Viktor();
        viktor.start();
    }
}
