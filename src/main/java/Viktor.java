import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Viktor {
    private static boolean testing = false;

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("testing")) {
            testing = false;
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

        TaskList taskList = new TaskList();  
        ArrayList<Task> tasks;

        try {
            tasks = taskList.load();
        } catch (IOException e) {
            System.out.println("\nNo saved tasks found. Starting fresh.\n");
            tasks = new ArrayList<>();
        }

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
                String  words[] = userInput.split(" ");
                Command command = Command.fromString(words[0]);

                switch (command) {
                case BYE:
                    System.out.println("\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n\n" +
                        "Goodbye. Remember, progress never rests." +
                        "\n\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n");
                    running = false;
                    break;

                case LIST:
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
                    break;

                case MARK:
                case UNMARK:
                case DELETE:
                    int taskNumber = Integer.parseInt(words[1]) - 1;
                    if (taskNumber >= tasks.size()) {
                        throw new ViktorException("You're asking for the impossible! That task doesn't exist.");
                    }

                    if (command == Command.MARK) {
                        tasks.get(taskNumber).beDone();
                        System.out.println("\n You've just finished " + tasks.get(taskNumber) 
                            + "! True progress is still far away but a bit less further now!\n");
                    } else if (command == Command.UNMARK) {
                        tasks.get(taskNumber).beUndone();
                        System.out.println("\n Oh you've yet to finish" + tasks.get(taskNumber) 
                            + "? Dont't forget: progress waits for no man\n");
                    } else { 
                        System.out.println("\n" + tasks.get(taskNumber) + " is no longer your concern.\n");
                        tasks.remove(taskNumber);
                        System.out.println('\n' + "Now you have " + tasks.size() + " remaining tasks.\n");
                    }
                    try {
                        taskList.save(tasks);
                    } catch (IOException e) {
                        System.out.println("Ah something must've gone awry: " + e.getMessage() 
                            + " Well, mistakes are but a part of progress.");
                    }
                    break;

                case TODO:
                case DEADLINE:
                case EVENT:
                    if (words.length < 2) {
                        throw new ViktorException("There's something you're not telling me!");
                    }
                    String taskDescription = userInput.substring(words[0].length()).trim();
                    String output;
                    if (command == Command.TODO) {
                        Todo todo = new Todo(taskDescription);
                        tasks.add(todo);
                        output = todo.getDescription();
                    } else if (command == Command.DEADLINE) {
                        String[] parts = taskDescription.split("/by");  
                        if (parts.length != 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
                            throw new ViktorException("Invalid deadline! Please focus, when is it due!!");
                        }
                        Deadline deadline = new Deadline(parts[0].trim(), parts[1].trim());
                        tasks.add(deadline);
                        output = deadline.getDescription();
                    } else { 
                        String[] parts = taskDescription.split("/from", 2);
                        if (parts.length < 2) {
                            throw new ViktorException("Invalid event! You have to give me some details.");
                        }
                        String[] timeParts = parts[1].split("/to", 2);
                        if (timeParts.length < 2) {
                            throw new ViktorException("Invalid event input! Please provide both start and end times.");
                        }
                        Event event = new Event(parts[0].trim(), timeParts[0].trim(), timeParts[1].trim());
                        tasks.add(event);
                        output = event.getDescription();
                    }
                    if (testing) {
                        System.out.println("\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n\n" +
                        testingResponse + " " + userInput + 
                        "\n\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n\n");
                    } else {
                        String response = responses[random.nextInt(responses.length)];
                        System.out.println("\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n\n" +
                        response + " " + output + "." + 
                        "\n\n⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅⋅.˳˳.⋅ॱ˙˙ॱ⋅.˳˳.⋅ॱ˙˙ॱᐧ.˳˳.⋅\n");
                    } 
                    try {
                        taskList.save(tasks);
                    } catch (IOException e) {
                        System.out.println("An error occurred while saving tasks: " + e.getMessage());
                    }
                    break;

                    default:
                        throw new ViktorException("Wait, what? I don't understand what you're saying...");
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
