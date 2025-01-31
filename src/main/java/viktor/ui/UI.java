package viktor.ui;

import java.util.List;
import java.util.Scanner;

import viktor.tasks.Task;


public class UI {
    public static final String LOGO = "\n" 
            + "\t" + "\u001B[32m" + "      .__ __      __                \n"
            + "\t" + "___  _|__|  | ___/  |_  ___________ \n"
            + "\t" + "\\  \\/ /  |  |/ /\\   __\\/  _ \\_  __ \\\n"
            + "\t" + " \\   /|  |    <  |  | (  <_> )  | \\/\n"
            + "\t" + "  \\_/ |__|__|_ \\ |__|  \\____/|__|   \n"
            + "\t" + "              \\/                    \n"
            + "\u001B[0m";
    public static final String CURLY_START = "\n" + "⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅" + "\n\n";
    public static final String CURLY_END = "\n\n" + "⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅" + "\n";

    private Scanner scanner;

    public UI() {
        this.scanner = new Scanner(System.in);
    }

    public void showWelcomeMessage() {
        System.out.println(CURLY_START 
            + "Hello! I'm Viktor" + "\n" + LOGO + "\n"+ "____________________________________________________________\n\n"
            + "Here are some of my advanced capabilities: \n\n" 
            + "ADD <task type> <description> - add task to your list\n"
            + "    e.g. add todo buy groceries" + "\n" + "    e.g. add deadline return book /by 2/12/2025 1800" 
                    + "\n" + "    e.g. add event meeting /at 2/12/2025 1800" + "\n\n"
            + "DELETE <task number> - remove a task from your list\n" 
            + "    e.g., delete 2" + "\n\n" 
            + "MARK <task number> - mark a task as done.\n" 
            + "    e.g., mark 3" + "\n\n"
            + "LIST - list all tasks in your list\n" 
            + "    e.g., list" + "\n\n"
            + "FIND <keyword> - find tasks with the keyword\n"
            + "    e.g., find book" + "\n\n"
            + "TIME <date> - list all tasks on a specific date\n"
            + "    e.g., time 2/12/2025" + "\n\n"
            + "BYE - exit the program\n"
            + "    e.g., bye" + "\n\n"
            + "____________________________________________________________\n\n"
            + "What can I do for you today?\n" 
            + CURLY_END);
    }

    public void showTaskList(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            tasks.forEach(task -> System.out.println(task));
        }
    }

    public void showErrorMessage(String message) {
        System.out.println("Error: " + message);
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
