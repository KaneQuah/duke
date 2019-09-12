/**
 * Abstract Command class
 * Superclass of all commands
 * Abstract Method execute
 * boolean exit
 * @author Kane Quah
 * @version 1.0
 * @since 09/19
 */
public abstract class Command {
    boolean exit = false;
    Command() {}
    /**
     * default execute
     * @param tasks TasksList Object being used currently
     * @param ui UI in charge of printing messages
     * @param storage Storage in charge of loading and saving files
     * @throws DukeException DukeException thrown when unable to execute
     */
    public abstract void execute(Tasklist tasks, UI ui, Storage storage) throws DukeException;

    /**
     * checks if the command is an ExitCommand
     * @return boolean if the system should exit or not
     */
    boolean isExit(){return this.exit;}
}
