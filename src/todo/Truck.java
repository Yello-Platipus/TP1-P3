package todo;

public class Truck extends Obstacle{

    static String INFO = "[TRUCK] moves towards the player\n";

    private static int numTrucks = 0;

    public Truck(Game game, int x, int y) {
        super(game, x, y);
        symbol = "←";
        hp = 1;
    }

    public static void reset(){
        numTrucks = 0;
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
