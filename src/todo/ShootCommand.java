package todo;

public class ShootCommand extends Command implements Buyable{

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
        if(buy(game)){
            game.executeInstantAction(new Shot());
            game.update();
            return true;
        }
        else{
            System.out.println("Not enough coins\n" +
                    "[ERROR]: Failed to shoot\n");
            return false;
        }

    }

    @Override
    public int cost() {
        return coinUsage;
    } // TODO mirar si funciona igual en eclipse
}
