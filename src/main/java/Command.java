enum Command {
    LIST, MARK, UNMARK, DELETE, TODO, DEADLINE, EVENT, BYE, UNKNOWN;

    public static Command fromString(String command) {
        try {
            return Command.valueOf(command.toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }
}
