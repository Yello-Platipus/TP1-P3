package todo;

import javax.print.attribute.standard.MediaSize;

public class WaveCommand extends Command{

    private static final String NAME = "generate objects";

    private static final String DETAILS = "Cheat [1..5]";

    private static final String SHORTCUT = "5";

    private static final String HELP = "Removes all elements of last visible column, and adds an Advanced Object";

    public WaveCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    public boolean execute(Game game) {
        return false;
    }
}
