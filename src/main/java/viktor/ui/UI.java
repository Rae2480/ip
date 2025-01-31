package viktor.ui;

import java.util.List;
import java.util.Scanner;

import viktor.tasks.Task;


public class UI {
    public static final String LOGO = "\n" 
            + "\t" + "      .__ __      __                \n"
            + "\t" + "___  _|__|  | ___/  |_  ___________ \n"
            + "\t" + "\\  \\/ /  |  |/ /\\   __\\/  _ \\_  __ \\\n"
            + "\t" + " \\   /|  |    <  |  | (  <_> )  | \\/\n"
            + "\t" + "  \\_/ |__|__|_ \\ |__|  \\____/|__|   \n"
            + "\t" + "              \\/                    \n";
    public static final String CURLY_START = "\n" + "⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅" + "\n\n";
    public static final String CURLY_END = "\n\n" + "⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅" + "\n";

    private Scanner scanner;

    public UI() {
        this.scanner = new Scanner(System.in);
    }

    public void showWelcomeMessage() {
        System.out.println(CURLY_START 
            + "Hello! I'm Viktor\n" + LOGO + "\n"+ "What can I do for you?\n" 
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
