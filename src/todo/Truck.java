package todo;

public class Truck extends GameObject{

    public Truck(Game game, int x, int y) {
        super(game, x, y);
    }

    @Override
    public boolean doCollision() {
        return false;
    }

    @Override
    public boolean receiveCollision(Player player) {
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
