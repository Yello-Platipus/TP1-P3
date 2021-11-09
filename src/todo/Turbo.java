package todo;

public class Turbo extends GameObject{

    private static int boost;

    public Turbo(Game game, int x, int y) {
        super(game, x, y);
        boost = 3;
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
    public boolean receiveShoot() {
        return false;
    }

    @Override
    public void onEnter() {

    }

    @Override
    public void update() {

    }

    @Override
    public void onDelete() {

    }
}
