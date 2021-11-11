package todo;

public class ShootCommand extends Command{

    private static final String NAME = "shoot a bullet";

    private static final String DETAILS = "[s]hoot";

    private static final String SHORTCUT = "s";

    private static final String HELP = "shoot bullet";

    public ShootCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }


    @Override
    public boolean execute(Game game) {
        boolean canShoot = game.getNumCoins() > 0;
        if(canShoot){
            game.executeInstantAction(new Shot());
            game.update();
        }
        else // TODO cual es el bueno?
            GamePrinter.notEnoughCoinsMessage();
            //game.notEnoughCoinsMessage();
        return canShoot;
    }
}
