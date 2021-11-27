package todo;

public class Truck extends Obstacle{

    static String INFO = "[TRUCK] moves towards the player\n";

    public Truck(Game game, int x, int y) {
        super(game, x, y);
        symbol = "←";
        hp = 1;
    }

    public static void reset(){

    }

    @Override
    public void onEnter() {

        numObs++;
        numObjects++;
    }

    @Override
    public void update() {
        x--;
    }

    @Override
    public void onDelete() {

        numObs--;
        numObjects--;
    }
}
