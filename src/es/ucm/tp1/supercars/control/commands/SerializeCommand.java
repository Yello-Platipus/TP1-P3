package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.view.GameSerializer;

public class SerializeCommand extends Command{

    private GameSerializer serializer;

    private static final String NAME = "serialize";

    private static final String DETAILS = "seriali[z]e";

    private static final String SHORTCUT = "z";

    private static final String HELP = "Serializes the board.";

    public SerializeCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        serializer = new GameSerializer(game);
        System.out.println(serializer.serialize());
        return false;
    }
}
