import java.util.Scanner;

/**
 * UI class, displays system messages
 * Collects User input;
 * @author Kane Quah
 * @version 1.0
 * @since 08/19
 */
class UI {
    private Scanner sc;
    private String loadingError = "Formatting Issues Encountered. New Task List initialized";
    private String line = "____________________________________________________________";
    private String goodBye = "Bye. Hope to see you again soon!";
    private String closeSuccess = "File successfully saved!";
    private String closeFail = "File failed to save";
    UI(){}

    /**
     * Displays Welcome message
     */
    void showWelcome(){
        this.sc = new Scanner(System.in);
        System.out.println("Hello! I'm Duke\n" +
                "What can I do for you?\n");
    }

    /**
     * Reads the next line, to be parsed by Parser
     * @return String next line
     * @throws DukeException DukeException thrown if forced to read when there is nothing
     */
    String readCommand() throws DukeException {
        if(sc.hasNextLine())
            return sc.nextLine();
        else throw new DukeException("There are no more lines to be read");

    }

    /**
     * Prints out a line of dashes
     */
    void showLine(){
        System.out.println(this.line);
    }

    /**
     * Prints out error
     * @param error String message from error
     */
    void showError(String error){
        System.out.println(error);
    }

    /**
     * Prints default loading error message
     */
    void showLoadingError(){
        System.out.println(this.loadingError);
    }

    /**
     * Prints out program termination line
     */
    void hastaLaVista(){System.out.println(this.goodBye);}

    /**
     * Closes the scanner
     */
    void close(){
        this.sc.close();
    }

    /**
     * Informs user if files were stored successfully
     */
    void closeSuccess() {System.out.println(this.closeSuccess);}

    /**
     * Informs user that files failed to store
     */
    void closeFailure() {System.out.println(this.closeFail);
    }
}
