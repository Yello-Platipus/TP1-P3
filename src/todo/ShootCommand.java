package todo;

public class ShootCommand extends Command{

    private static final String NAME = "shoot a bullet";

    private static final String DETAILS = "[s]hoot";

    private static final String SHORTCUT = "s";

    private static final String HELP = "shoot bullet";

    private static int coinUsage = 1;

    public ShootCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    public boolean execute(Game game) {
        boolean canShoot = game.getNumCoins() > 0;
        if(canShoot){
            game.useCoins(coinUsage);
            game.executeInstantAction(new Shot());
            game.update();
        }
        else
            System.out.println("Not enough coins");
        return canShoot;
    }
}
