package todo;

public class Pedestrian extends GameObject{

    static String INFO = "[PEDESTRIAN] person crossing the road up and down\n";

    public Pedestrian(Game game, int x, int y) {
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
    public boolean receiveShot() {
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
