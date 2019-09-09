public abstract class Command {
    boolean exit = false;
    Command() {}
    public abstract void execute(Tasklist tasks, UI ui, Storage storage) throws DukeException;
    boolean isExit(){return this.exit;}
}
