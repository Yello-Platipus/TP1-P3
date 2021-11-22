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
        if(buy(game)) {
            for (int i = game.getXPlayer() + game.getVisibility(); i >= game.getXPlayer(); i--) {
                for (int j = game.getWidth(); j >= 0; j--) {
                    GameObject o = game.getObjectInPos(i, j);
                    if (o != null && game.getObjectInPos(o.getX() + 1, o.getY()) == null)
                        o.receiveWave();
                }
            }
        }
        return true;
    }

    @Override
    public int cost() {
        return coinUsage;
    }
}
