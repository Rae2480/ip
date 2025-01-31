package viktor.commands;

import viktor.exceptions.ViktorException;

/**
 * Represents a command that can be executed.
 */
public interface Commandable {
    
    /**
     * Executes the command.
     * 
     * @throws ViktorException If an error occurs during execution.
     */
    void execute() throws ViktorException;
}
