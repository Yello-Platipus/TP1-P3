package todo;

public class MoveUpCommand extends Command{

    private static final String NAME = "move up";

    private static final String DETAILS = "[q]";

    private static final String SHORTCUT = "q";

    private static final String HELP = "go up";

    public MoveUpCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    public boolean execute(Game game) {
        game.updateDeadObjects();
        game.moveUp();
        game.update();
        return true;
    }
}
