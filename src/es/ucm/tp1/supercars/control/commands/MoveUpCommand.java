package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.logic.Game;

public class MoveUpCommand extends Command{

    private static final String NAME = "up";

    private static final String DETAILS = "[q]";

    private static final String SHORTCUT = "q";

    private static final String HELP = "go up";

    public MoveUpCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        game.updateDeadObjects();
        game.moveUp();
        game.update();
        return true;
    }
}
