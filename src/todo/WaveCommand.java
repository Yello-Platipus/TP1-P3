package todo;

public class WaveCommand extends Command implements Buyable{

    private static final String NAME = "creates a wave that pushes objects";

    private static final String DETAILS = "[w]ave";

    private static final String SHORTCUT = "w";

    private static final String HELP = "do wave";

    private int coinUsage = 5;

    public WaveCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    public boolean execute(Game game) {
        buy(game);
        game.pushSeenObjects();
        return true;
    }

    @Override
    public int cost() {
        return coinUsage;
    }
}
