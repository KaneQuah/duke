/**
 * ModCommand Class extends the abstract Command class
 * Called when modifying a task in tasks
 * @author Kane Quah
 * @version 1.0
 * @since 09/19
 */
public class ModCommand extends Command {
    private String command;
    private String input;
    ModCommand(String command, String input){
        this.command = command;
        this.input = input;
    }
    /**
     * default execute overwritten to modify task in tasks
     * @param tasks TasksList Object being used currently
     * @param ui UI in charge of printing messages
     * @param storage Storage in charge of loading and saving files
     * @throws DukeException DukeException thrown when unable to execute
     */
    public void execute(Tasklist tasks, UI ui, Storage storage) throws DukeException {
        if(this.command.matches("done")){
            tasks.markDone(this.input);
        }
        else if(this.command.matches("delete"))
        {
            tasks.banishDelete(this.input);
        }
    }

}
