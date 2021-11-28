package todo;

public class GrenadeCommand extends Command implements Buyable{

    private static final String NAME = "generates a grenade in a given position";

    private static final String DETAILS = "[g]renade <x> <y>";

    private static final String SHORTCUT = "g";

    private static final String HELP = "add a grenade in position x, y";

    private int coinUsage = 3;

    private int x;

    private int y;

    public GrenadeCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    public boolean execute(Game game) {
        if(game.getObjectInPos(game.getXPlayer() + x, y) == null){
            if(buy(game)) {
                game.createGrenade(new Grenade(game, x + game.getXPlayer(), y));
                game.update();

                return true;
            }
            else
                System.out.println("Insufficient funds for this action");
        }
        else
            System.out.println("Invalid position.\n[ERROR]: Failed to add grenade\n");
        return false;
    }

    @Override
    protected Command parse(String[] words){
        if (matchCommandName(words[0])) {
            if (words.length != 3) {
                System.out.format("[ERROR]: Command %s: %s%n%n", NAME, INCORRECT_NUMBER_OF_ARGS_MSG);
                return null;
            } else {
                x = Integer.parseInt(words[1]);
                y = Integer.parseInt(words[2]);
                return this;
            }
        }
        return null;
    }

    @Override
    public int cost() {
        return coinUsage;
    }
}
