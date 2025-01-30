package viktor.commands;

import viktor.exceptions.ViktorException;

public interface Commandable {
    void execute() throws ViktorException;
}
