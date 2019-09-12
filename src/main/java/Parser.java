import java.util.Scanner;

/**
 * Parser class
 * Handles Raw Input and determines if it is a valid command
 * If not a valid command, it will return a BadCommand
 */
class Parser {
    static String deadline = "\\s*/by\\s*";
    static String event = "\\s*/at\\s*";
    static String taskSeparator = "\\s*\\|\\s*";
    static String newLine = "\n";
    Parser(){}

    /**
     * Returns the appropiate command based on line input
     * @param line String which is the next line of input
     * @return Command
     * @throws DukeException
     */
    static Command parse(String line) throws DukeException {
        Scanner temp = new Scanner(line);
        if(!temp.hasNext()){
            throw new DukeException("Empty Command!");
        }
        String command = temp.next();
        if (command.matches("list|bye")) {
            if (temp.hasNextLine()) {
                throw new DukeException("List should not have any other arguments (whitespace acceptable");
            }
            else{
                if(command.matches("list"))
                {
                    return new PrintCommand(){};
                }
                else if (command.matches("bye"))
                {
                    return new ExitCommand();
                }
            }
        }
        else if (command.matches("todo|deadline|event|done|delete|find")) {
            if(!temp.hasNextLine())
                throw new DukeException("☹ OOPS!!! The description of a " + command + " cannot be empty.");
            String input = temp.nextLine();
            input = input.strip();
            //System.out.println("input is" + input + "\nCommand is" + command);

            if(input.isBlank())
            {
                throw new DukeException("☹ OOPS!!! The description of a " + command + " cannot be empty.");
            }
            else {
                if(command.matches("todo|deadline|event"))
                {
                    return new AddCommand(command, input);
                }
                else if(command.matches("done|delete"))
                {
                    return new ModCommand(command, input);
                }
                else if (command.matches("find"))
                {
                    return new SearchCommand(command, input);
                }
            }
        }
        return new BadCommand("bad", "");
    }
}
