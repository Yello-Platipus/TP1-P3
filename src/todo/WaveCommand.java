package todo;

import javax.print.attribute.standard.MediaSize;

public class WaveCommand extends Command{

    private static final String NAME = "creates a wave that pushes objects";

    private static final String DETAILS = "[w]ave";

    private static final String SHORTCUT = "w";

    private static final String HELP = "do wave";

    public WaveCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    public boolean execute(Game game) {
        return false;
    }
}
