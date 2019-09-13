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
     * executes default
     * @param tasks TasksList has tasks
     * @param ui UI prints messages
     * @param storage Storage loads and saves files
     * @throws DukeException DukeException throws exception
     */
    public abstract void execute(Tasklist tasks, UI ui, Storage storage) throws DukeException;

    /**
     * checks if the command is an ExitCommand
     * @return boolean if the system should exit or not
     */
    boolean isExit(){return this.exit;}
}
