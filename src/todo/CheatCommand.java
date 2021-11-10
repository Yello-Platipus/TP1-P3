package todo;

public class CheatCommand extends Command{

    private static final String NAME = "clear";

    private static final String DETAILS = "Cheat [1..5]";

    private static final String SHORTCUT[] = new String[5];

    private static final String HELP = "Removes all elements of last visible column, and adds an Advanced Object";

    public CheatCommand() {
        super(NAME, SHORTCUT[0], DETAILS, HELP);
    }

    @Override
    public boolean execute(Game game) {
        return false;
    }
}
