import java.util.Random;
import java.util.Scanner;

public class Viktor {
    public static void main(String[] args) {
        String name = "Viktor";
        String logo = "\n" 
                + "\t" + "      .__ __      __                \n"
                + "\t" + "___  _|__|  | ___/  |_  ___________ \n"
                + "\t" + "\\  \\/ /  |  |/ /\\   __\\/  _ \\_  __ \\\n"
                + "\t" + " \\   /|  |    <  |  | (  <_> )  | \\/\n"
                + "\t" + "  \\_/ |__|__|_ \\ |__|  \\____/|__|   \n"
                + "\t" + "              \\/                    \n";
        System.out.println(
            "\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n\n" + 
            "Hello! I'm " + name + "\n" + logo + "\n" +
            "What can I do for you?\n" +
            "\n\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n");

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean running = true;

        while (running) {
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println("\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n\n" +
                "Goodbye. Remember, progress never rests." +
                "\n\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n");
                running = false;
            } else {
                String[] responses = {
                    "The pursuit of knowledge is a noble endeavor. So is",
                    "Progress requires sacrifice, but it is always worth the cost for",
                    "Even the greatest minds require assistance sometimes. You seek to know about",
                    "Ah, progress—the double-edged sword of innovation, alongside:",
                    "Every leap forward brings challenges, but such is the price of",
                    "Interesting... Perhaps you could explain further about this"
                };
                String response = responses[random.nextInt(responses.length)];
                System.out.println("\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n\n" +
                response + " " + userInput + "." + "\n\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n");
            }
        }

        scanner.close();
    }
}
