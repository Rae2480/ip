import java.util.Scanner;

public class Viktor {
    public static void main(String[] args) {
        String name = "Viktor";
        String logo = "      .__ __      __                \n"
                + "___  _|__|  | ___/  |_  ___________ \n"
                + "\\  \\/ /  |  |/ /\\   __\\/  _ \\_  __ \\\n"
                + " \\   /|  |    <  |  | (  <_> )  | \\/\n"
                + "  \\_/ |__|__|_ \\ |__|  \\____/|__|   \n"
                + "              \\/                    ";
        System.out.println(
            "----------------------------------------------------------\n" + 
            "Hello! I'm " + name + "\n" + logo + "\n" +
            "What can I do for you?\n" +
            "----------------------------------------------------------\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("\n");
        String userInput = scanner.nextLine();

        while (!userInput.equals("bye")) {
            System.out.println(
                "----------------------------------------------------------\n" +
                "\t" + userInput + "\n" +
                "----------------------------------------------------------\n");
            userInput = scanner.nextLine();
        } 
        System.out.println(
            "----------------------------------------------------------\n" +
            "Bye. Hope to see you again soon!" + "\n" +
            "----------------------------------------------------------\n");

        scanner.close();

    }
}
