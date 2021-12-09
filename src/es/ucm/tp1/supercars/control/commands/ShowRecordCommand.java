package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.logic.Game;

public class ShowRecordCommand extends Command{

    private static final String NAME = "show record";

    private static final String DETAILS = "rec[o]rd";

    private static final String SHORTCUT = "o";

    private static final String HELP = "Shows the record for the current level";

    public ShowRecordCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        System.out.format(game.getLevel().toString() + " record is %.2f s\n", (double)game.getRecord() / 1000);
        return false;
    }
}
