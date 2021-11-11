package todo;

public class Turbo extends GameObject{

    private static int boost;
    private static int numTurbos = 0;
    static String INFO = "[TURBO] pushes the car 3 columns\n";

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
    public boolean receiveExplosion() {
        return false;
    }

    @Override
    public void onEnter() {
        numTurbos++;
        numObjects++;
    }

    @Override
    public void update() {

    }

    @Override
    public void onDelete() {
        numTurbos--;
        numObjects--;
    }
}
