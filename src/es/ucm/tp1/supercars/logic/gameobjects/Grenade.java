package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.actions.Explosion;

public class Grenade extends GameObject{

    public static String INFO = "[GRENADE] Explodes in 3 cycles, harming everyone around\n";

    public Grenade(Game game, int x, int y) {
        super(game, x, y);
        hp = 4;
        symbol = "ð[3]";
    }

    @Override
    public String serialize(){
        StringBuilder ret = new StringBuilder(toString());
        ret.append(" (" + x + ", " + y + ") " + hp + "\n");
        return ret.toString();
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

    }

    @Override
    public void update() {
        hp--;
        symbol = "ð[" + (hp) + "]";
    }

    @Override
    public void onDelete() {
        new Explosion(x, y).execute(game);
    }
}
