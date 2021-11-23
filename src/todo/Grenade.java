package todo;

public class Grenade extends GameObject{

    static String INFO = "[GRENADE] Explodes in 3 cycles, harming everyone around\n";

    public Grenade(Game game, int x, int y) {
        super(game, x, y);
        hp = 2;
        symbol = "ð[3]";
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
    public boolean receiveThunder() {
        return false;
    }

    @Override
    public void onEnter() {
        numObjects++;
    }

    @Override
    public void update() {
        hp--;
        symbol = "ð[" + (hp + 1) + "]";
    }

    @Override
    public void onDelete() {
        game.executeInstantAction(new Explosion(x, y));
        numObjects--;
    }
}
