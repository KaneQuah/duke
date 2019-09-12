/**
 * SearchCommand Class extends the abstract Command class
 * Called when Searching for items in tasks
 * @author Kane Quah
 * @version 1.0
 * @since 09/19
 */
public class SearchCommand extends Command {
    private String command;
    private String arguments;
    SearchCommand(String command, String input){
        this.command = command;
        this.arguments = input;
    }
    /**
     * default execute overwritten to search task in tasks
     * @param tasks TasksList Object being used currently
     * @param ui UI in charge of printing messages
     * @param storage Storage in charge of loading and saving files
     * @throws DukeException DukeException thrown when unable to execute
     */
    public void execute(Tasklist tasks, UI ui, Storage storage) throws DukeException {
        if(this.command.matches("find")){
            tasks.find(this.arguments);
        }
    }
}
