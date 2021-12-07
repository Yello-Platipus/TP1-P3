package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

public class ResetCommand extends Command{

    private long seed;

    private String levelName;

    private static final String NAME = "reset";

    private static final String DETAILS = "[r]eset [<level> <seed>]";

    private static final String SHORTCUT = "r";

    private static final String HELP = "reset game";

    public ResetCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    protected Command parse(String[] words) throws CommandParseException {
        if (matchCommandName(words[0])) {
            if(words.length == 3){
                if(Level.valueOfIgnoreCase(words[1]) == null){
                    throw new CommandParseException(String.format("[ERROR]: Command %s: %s", NAME, "Level must be one of: TEST, EASY, HARD, ADVANCED"));
                }
                else {
                    levelName = words[1];
                    seed = Long.parseLong(words[2]);
                    return this;
                }
            }
            else if(words.length == 1){
                seed = -1;
                levelName = "";
                return this;
            }
            else {
                throw new CommandParseException(String.format("[ERROR]: Command %s: %s", NAME, INCORRECT_NUMBER_OF_ARGS_MSG));
            }
        }
        return null;
    }

    @Override
    public boolean execute(Game game) {
        Level level;
        if(seed == -1 && levelName.equals("")){
            seed = game.getSeed();
            level = game.getLevel();
        }
        else{
            level = Level.valueOfIgnoreCase(levelName);
            System.out.println("Level: "+ levelName.toUpperCase());
            System.out.println("Random generator initialized with seed: "+ seed);
        }

        game.reset(seed, level);
        return true;
    }
}
