package todo;

public class Truck extends GameObject{

    static String INFO = "[TRUCK] moves towards the player\n";

    private static int numTrucks = 0;

    public Truck(Game game, int x, int y) {
        super(game, x, y);
        symbol = "←";
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
    public void onEnter() {
        numTrucks++;
        numObjects++;
    }

    @Override
    public void update() {
        x--;
    }

    @Override
    public void onDelete() {
        numTrucks--;
        numObjects--;
    }
}
