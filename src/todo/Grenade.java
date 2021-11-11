package todo;

public class Grenade extends GameObject{

    static String INFO = "[GRENADE] Explodes in 3 cycles, harming everyone around\n";

    public Grenade(Game game, int x, int y) {
        super(game, x, y);
        hp = 3;
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
    public boolean receiveExplosion() {
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
