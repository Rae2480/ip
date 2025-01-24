import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Viktor {
    private static boolean testing = false;

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("testing")) {
            testing = true;
        }
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
        ArrayList<Task> tasks = new ArrayList<>();
        String[] responses = {
            "The pursuit of knowledge is a noble endeavor. I've added",
            "Progress requires sacrifice, but it is always worth the cost for",
            "Even the greatest minds require assistance sometimes. You seek to",
            "Ah, progress—the double-edged sword of innovation, alongside:",
            "Every leap forward brings challenges, but such is the price of this great task,",
            "Interesting... I will have to do more research about this"
        };
        String testingResponse = ("Even the greatest minds require assistance sometimes. You seek to");


        while (running) {
            String userInput = scanner.nextLine();
            try {
                if (userInput.equalsIgnoreCase("bye")) {
                    System.out.println("\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n\n" +
                    "Goodbye. Remember, progress never rests." +
                    "\n\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n");
                    running = false;
                } else if (userInput.equalsIgnoreCase("list")) {
                    System.out.println("\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n\n" +
                    "Your tasks await you: \n");

                    if (tasks.isEmpty()) {
                        System.out.println("No tasks added yet!" +
                        "\n\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    System.out.println('\n' + "Now you have " + tasks.size() + " tasks in the list." +
                    "\n\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n");
                    }
                } else if (userInput.startsWith("mark")) {
                    String[] words = userInput.split(" ");
                    int taskNumber = Integer.parseInt(words[1]) - 1;
                    if (taskNumber >= tasks.size()) {
                        throw new ViktorException("You're asking for the impossible! That task doesn't exist.");
                    }
                    tasks.get(taskNumber).beDone();
                    System.out.println("\n" + tasks.get(taskNumber) + " is marked done!\n");

                } else if (userInput.startsWith("unmark")) {
                    String[] words = userInput.split(" ");
                    int taskNumber = Integer.parseInt(words[1]) - 1;
                    if (taskNumber >= tasks.size()) {
                        throw new ViktorException("You're asking for the impossible! That task doesn't exist.");
                    }
                    tasks.get(taskNumber).beUndone();
                    System.out.println("\n" + tasks.get(taskNumber) + " is marked not done yet\n");

                } else if (userInput.startsWith("delete")) {
                    String[] words = userInput.split(" ");
                    int taskNumber = Integer.parseInt(words[1]) - 1;
                    if (taskNumber >= tasks.size()) {
                        throw new ViktorException("You're asking for the impossible! That task doesn't exist.");
                    }
                    System.out.println("\n" + tasks.get(taskNumber) + " is removed from the list\n");
                    tasks.remove(taskNumber);
                    System.out.println('\n' + "Now you have " + tasks.size() + " tasks in the list.\n");
                    
                } else {  
                    // 3 types of tasks: todo, deadline, event
                    if (userInput.startsWith("todo")) {
                        userInput = userInput.replace("todo", "").trim();
                        if (userInput.isEmpty()) {
                            throw new ViktorException("Are you feeling quite alright? The description of a todo cannot be empty!");
                        }
                        tasks.add(new Todo(userInput));

                    } else if (userInput.startsWith("deadline")) {
                        userInput = userInput.replace("deadline", "").trim();
                        String[] parts = userInput.split("/by");
                        if (parts.length < 2) { // either description or time missing
                            throw new ViktorException("Don't be silly! Your deadline task is unclear.");
                        }
                        tasks.add(new Deadline(parts[0], parts[1]));

                    } else if (userInput.startsWith("event")) {
                        userInput = userInput.replace("event", "").trim();
                        String[] parts = userInput.split("/from");
                        if (parts.length < 2) { // either description or times missing
                            throw new ViktorException("You realise just said gibberish? Your event details are incomplete.");
                        }
                        String[] timeParts = parts[1].split("/to");
                        if (timeParts.length < 2) {
                            throw new ViktorException("Please slow down, incompetence isn't my first language.");
                        }
                        tasks.add(new Event(parts[0], timeParts[0], timeParts[1]));
                    } else {
                        throw new ViktorException("Wait, what? I don't understand what you're saying...");
                    }

                    if (testing) {
                        System.out.println("\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n\n" +
                        testingResponse + " " + userInput + 
                        "\n\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n\n");
                    } else {
                        String response = responses[random.nextInt(responses.length)];
                        System.out.println("\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n\n" +
                        response + " " + userInput + "." + 
                        "\n\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n");
                    }
                }
                
            } catch (ViktorException e) {
                System.out.println("\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n\n" +
                                   e.getMessage() + 
                                   "\n\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n");
            }

        }

        scanner.close();
    }
}
