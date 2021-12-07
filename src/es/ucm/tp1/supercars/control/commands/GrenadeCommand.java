package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
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
    public boolean execute(Game game) {
        if(!game.outOfBounds(x,y)){
            if(buy(game)) {
                x = x + game.getXPlayer();
                GameObject grenade = new Grenade(game, x, y);
                game.addObjectContainer(grenade);
                game.update();
                return true;
            }
            else
                System.out.println("Insufficient funds for this action");
        }
        else
            System.out.println("Invalid position.\n[ERROR]: Failed to add grenade\n");
        return false;
    }

    @Override
    protected Command parse(String[] words) throws CommandParseException {
        if (matchCommandName(words[0])) {
            if (words.length != 3) {
                throw new CommandParseException(String.format("[ERROR]: Command %s: %s", NAME, INCORRECT_NUMBER_OF_ARGS_MSG));
            }
            else {

                x = Integer.parseInt(words[1]);
                y = Integer.parseInt(words[2]);
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
