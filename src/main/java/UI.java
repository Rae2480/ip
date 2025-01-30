import java.util.List;
import java.util.Scanner;

public class UI {
    String name = "Viktor";
    String logo = "\n" 
            + "\t" + "      .__ __      __                \n"
            + "\t" + "___  _|__|  | ___/  |_  ___________ \n"
            + "\t" + "\\  \\/ /  |  |/ /\\   __\\/  _ \\_  __ \\\n"
            + "\t" + " \\   /|  |    <  |  | (  <_> )  | \\/\n"
            + "\t" + "  \\_/ |__|__|_ \\ |__|  \\____/|__|   \n"
            + "\t" + "              \\/                    \n";

    private Scanner scanner;

    public UI() {
        this.scanner = new Scanner(System.in);
    }

    public void showWelcomeMessage() {
        System.out.println("⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n\n" 
            + "Hello! I'm Viktor\n" + logo + "\n"+ "What can I do for you?\n" 
            + "\n\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n");
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
