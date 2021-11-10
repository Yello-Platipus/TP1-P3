package todo;

public class CheatCommand extends Command{

    private static final String NAME = "generate objects";

    private static final String DETAILS = "Cheat [1..5]";

    private static final String SHORTCUT = "5";

    private static final String HELP = "Removes all elements of last visible column, and adds an Advanced Object";

    private static int command;

    public CheatCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    public boolean execute(Game game) {
        game.forceAdvanceObject(command);
        return false;
    }

    @Override
    protected Command parse(String[] words){
        int command = Integer.parseInt(words[0]);
        if(0 < command && command < 6){
            if (words.length != 1) {
                System.out.format("[ERROR]: Command %s: %s%n%n", NAME, INCORRECT_NUMBER_OF_ARGS_MSG);
                return null;
            } else {
                this.command = command;
                return this;
            }
        }
        return null;
    }
}
