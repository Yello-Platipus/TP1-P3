package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

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
    protected Command parse(String[] words) throws CommandParseException {
        try {
            command = Integer.parseInt(words[0]);
            if(MIN_OBJ_ID <= command && command <= MAX_OBJ_ID){
                if (words.length != 1) {
                    throw new CommandParseException(String.format("[ERROR]: Command %s: %s", NAME, INCORRECT_NUMBER_OF_ARGS_MSG));
                } else {
                    this.command = command;
                    return this;
                }
            }
        }
        catch (NumberFormatException e)
        {
            return null;
        }
        return null;
    }
}
