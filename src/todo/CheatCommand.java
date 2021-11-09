package todo;

public class CheatCommand extends Command{

    private static final String NAME = "clear";

    private static final String DETAILS = "Cheat [0]";

    private static final String SHORTCUT = "0";

    private static final String HELP = "Clears the road";

    public CheatCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    public boolean execute(Game game) {
        return false;
    }
}
