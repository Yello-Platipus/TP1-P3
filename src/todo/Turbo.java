package todo;

public class Turbo extends GameObject{

    private static int boost;

    static String INFO = "[TURBO] pushes the car: 3 columns\n";

    public Turbo(Game game, int x, int y) {
        super(game, x, y);
        boost = 3;
        symbol = ">>>";
    }

    @Override
    public boolean doCollision() {
        return false;
    }

    @Override
    public boolean receiveCollision(Player player) {
        player.pickUpTurbo(boost);
        return false;
    }

    @Override
    public boolean receiveShot() {
        return false;
    }

    @Override
    public boolean receiveThunder() {
        return false;
    }

    @Override
    public void onEnter() {

        numObjects++;
    }

    public static void reset(){

    }

    @Override
    public void update() {

    }

    @Override
    public void onDelete() {

        numObjects--;
    }
}
