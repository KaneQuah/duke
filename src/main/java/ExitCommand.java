/**
 * ExitCommand Class extends the abstract Command class
 * Called when user wants to exit
 * @author Kane Quah
 * @version 1.0
 * @since 09/19
 */
public class ExitCommand extends Command {
    ExitCommand(){
        this.exit = true;
    }
    /**
     * default execute overwritten to add tasks to function
     * @param tasks TasksList Object being used currently
     * @param ui UI in charge of printing messages
     * @param storage Storage in charge of loading and saving files
     * @throws DukeException DukeException thrown when unable to execute
     */
    public void execute(Tasklist tasks, UI ui, Storage storage) throws DukeException {
        boolean isClose = true;
        try {
            storage.store(tasks);
        }
        catch (DukeException e)
        {
            isClose = false;
            throw new DukeException("Exit Error:" + e.getLocalizedMessage());
        }
        finally {
            ui.hastaLaVista();
            if(isClose)
                ui.closeSuccess();
            else
                ui.closeFailure();
            ui.close();
        }
    }
}
