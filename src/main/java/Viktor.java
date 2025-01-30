import java.io.IOException;
import java.util.ArrayList;

public class Viktor {

    private UI ui;
    private TaskList taskList;
    private Parser parser;

    // Constructor
    public Viktor() {
        ui = new UI();
        taskList = new TaskList();
        parser = new Parser();
    }

    // Start the chatbot
    public void start() {
        String userInput;
        ui.showWelcomeMessage();
        
        try {
            ArrayList<Task> loadedTasks = Storage.load(); // Load tasks from file
            taskList.setTasks(loadedTasks); // Assuming you have a method to set tasks
        } catch (IOException e) {
            System.out.println("No previous tasks found. Starting with an empty task list.");
        }

        while (true) {
            userInput = ui.readCommand();
            try {
                Commandable command = parser.parse(userInput, taskList, false); 
                command.execute();
                if (command instanceof ByeCommand) {
                    break; 
                }
            } catch (ViktorException e) {
                ui.showErrorMessage(e.getMessage());
            } catch (Exception e) {
                ui.showErrorMessage("Something went wrong!");
            }
        }

        ui.closeScanner();
    }

    // Main method to start Viktor
    public static void main(String[] args) {
        Viktor viktor = new Viktor();
        viktor.start();
    }
}
