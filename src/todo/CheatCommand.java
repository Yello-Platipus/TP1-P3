package todo;

public class CheatCommand extends Command{

    private static final String NAME = "generate objects";

    private static final String DETAILS = "Cheat [1..5]";

    private static final String SHORTCUT = "0";

    private static final String HELP = "Removes all elements of last visible column, and adds an Advanced Object";

    private static int command;

    public CheatCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    public boolean execute(Game game) {
        game.forceAdvancedObject(command);
        return true;
    }

    @Override
    protected Command parse(String[] words){
        int command = Integer.parseInt(words[0]);
        if(MIN_OBJ_ID <= command && command <= MAX_OBJ_ID){
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
