package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.actions.Wave;

public class WaveCommand extends Command implements Buyable {

    private static final String NAME = "creates a wave that pushes objects";

    private static final String DETAILS = "[w]ave";

    private static final String SHORTCUT = "w";

    private static final String HELP = "do wave";

    private static final int coinUsage = 5;

    public WaveCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {

        try{
            buy(game);
        }
        catch (NotEnoughCoinsException ex){
            throw new CommandExecuteException(ex.getMessage());
        }

        game.executeInstantAction(new Wave());
        game.update();
        return true;
    }

    @Override
    public int cost() {
        return coinUsage;
    }
}
