package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.control.exceptions.InvalidPositionException;
import es.ucm.tp1.supercars.control.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;
import es.ucm.tp1.supercars.logic.gameobjects.Grenade;

public class GrenadeCommand extends Command implements Buyable {

    private static final String NAME = "generates a grenade in a given position";

    private static final String DETAILS = "[g]renade <x> <y>";

    private static final String SHORTCUT = "g";

    private static final String HELP = "add a grenade in position x, y";

    private int coinUsage = 3;

    private int x;

    private int y;

    public GrenadeCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        try{game.outOfBounds(x, y);}
        catch (InvalidPositionException ex){
            throw new CommandExecuteException(ex.getMessage()+"[ERROR]: Failed to add grenade\n");
        }

        try{buy(game);}
        catch (NotEnoughCoinsException ex) {
            throw new CommandExecuteException(ex.getMessage());
        }
        x = x + game.getXPlayer();
        GameObject grenade = new Grenade(game, x, y);
        game.addObjectContainer(grenade);
        game.update();
        return true;



    }

    @Override
    protected Command parse(String[] words) throws CommandParseException {
        if (matchCommandName(words[0])) {
            if (words.length != 3) {
                throw new CommandParseException("[ERROR]: Incorrect number of arguments for grenade command: [g]renade <x> <y>");
            }
            else {
                try{
                    x = Integer.parseInt(words[1]);
                    y = Integer.parseInt(words[2]);
                }
                catch (NumberFormatException ex){
                    throw new CommandParseException("[ERROR]: Incorrect data type introduced for grenade command: [g]renade int int");
                }
                return this;
            }
        }
        return null;
    }

    @Override
    public int cost() {
        return coinUsage;
    }
}
