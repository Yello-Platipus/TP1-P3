package todo;

public class Pedestrian extends GameObject{

    static String INFO = "[PEDESTRIAN] person crossing the road up and down\n";
    private static int numPedestrians = 0;

    public Pedestrian(Game game, int x, int y) {
        super(game, x, y);
        symbol = "☺";
        hp = 1;
    }

    @Override
    public boolean doCollision() {
        return false;
    }

    @Override
    public boolean receiveCollision(Player player) {
        player.zeMato();
        return true;
    }

    @Override
    public boolean receiveShot() {
        hp--;
        return true;
    }

    @Override
    public boolean receiveExplosion() {
        hp--;
        return true;
    }

    @Override
    public void onEnter() {
        numPedestrians++;
        numObjects++;
    }

    @Override
    public void update() {

    }

    @Override
    public void onDelete() {
        numPedestrians--;
        numObjects--;
    }
}
