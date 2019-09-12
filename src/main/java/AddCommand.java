/**
 * AddCommand Class extends the abstract Command class
 * Called when items should be ADDED to tasks
 * @author Kane Quah
 * @version 1.0
 * @since 09/19
 */
public class AddCommand extends Command {
    private String arguments;
    private String command;
    AddCommand(String command, String arguments){
        this.command = command;
        this.arguments = arguments;
    }

    /**
     * default execute overwritten to add tasks to function
     * @param tasks TasksList Object being used currently
     * @param ui UI in charge of printing messages
     * @param storage Storage in charge of loading and saving files
     * @throws DukeException DukeException thrown when unable to execute
     */
    public void execute(Tasklist tasks, UI ui, Storage storage) throws DukeException {
        tasks.add(this.command, this.arguments);
    }

}
