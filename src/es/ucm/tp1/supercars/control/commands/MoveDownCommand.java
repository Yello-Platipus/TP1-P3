package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.logic.Game;

public class MoveDownCommand extends Command{

    private static final String NAME = "down";

    private static final String DETAILS = "[a]";

    private static final String SHORTCUT = "a";

    private static final String HELP = "go down";

    public MoveDownCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        game.updateDeadObjects();
        game.moveDown();
        game.update();
        return true;
    }
}
