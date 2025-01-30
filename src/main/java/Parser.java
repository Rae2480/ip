
public class Parser {

    public Commandable parse(String userInput, TaskList tasks, boolean testing) throws ViktorException {
        String[] words = userInput.split(" ", 2);
        String commandWord = words[0];

        switch (commandWord.toUpperCase()) {
        case "ADD":
            if (words.length < 2) {
                throw new ViktorException("Add? Add what?");
            }
            return new AddTaskCommand(words[1], tasks, testing);

        case "DELETE":
            if (words.length < 2) {
                throw new ViktorException("You don't even know what you want me to delete?");
            }
            try {
                int taskNumber = Integer.parseInt(words[1]);
                return new DeleteTaskCommand(taskNumber - 1, tasks); 
            } catch (NumberFormatException e) {
                throw new ViktorException("Invalid task number for deletion.");
            }

        case "MARK":
            if (words.length < 2) {
                throw new ViktorException("One does not simply mark a task without specifying which one.");
            }
            try {
                int taskNumber = Integer.parseInt(words[1]);
                return new MarkCommand(taskNumber - 1, tasks); 
            } catch (NumberFormatException e) {
                throw new ViktorException("Invalid task number to mark.");
            }

        case "UNMARK":
            if (words.length < 2) {
                throw new ViktorException("You've got to be clearer what you want me to unmark.");
            }
            try {
                int taskNumber = Integer.parseInt(words[1]);
                return new UnmarkCommand(taskNumber - 1, tasks); 
            } catch (NumberFormatException e) {
                throw new ViktorException("Invalid task number to unmark.");
            }

        case "LIST":
            return new ListCommand(tasks);

        case "BYE":
            return new ByeCommand();

        case "TIME":
            if (words.length < 2) {
                throw new ViktorException("Please specify a date for the search.");
            }
            return new TimeCommand(tasks, words[1]);

        default:
            throw new ViktorException("Unknown command: " + commandWord);
        }
    }
}
