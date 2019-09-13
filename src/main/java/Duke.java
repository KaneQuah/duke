/**
 * Duke main class
 * @author Kane Quah
 * @version 1.0
 * @since 08/2019
 */
public class Duke {
    private Tasklist taskList;
    private UI ui;
    private Storage storage;

    /**
     * initializes Duke class
     * @param filePath String is file name to be loaded
     */
    private Duke(String filePath) {
        this.ui = new UI();
        this.storage = new Storage(filePath);
        try {
            taskList = new Tasklist(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError();
            taskList = new Tasklist();
        }
    }

    /**
     * runs main program
     */
    private void run() {
        ui.showWelcome();
        boolean isExit = false;
        while(!isExit) {
            try {
                String line = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(line);
                isExit = c.isExit();
                c.execute(this.taskList, this.ui, this.storage);
            } catch (DukeException | NullPointerException e) {
                ui.showError(e.getLocalizedMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * main class
     * @param args String array throws system messages
     */
    public static void main(String[] args) {
        new Duke("duke.txt").run();
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.exit(0);
    }

}
