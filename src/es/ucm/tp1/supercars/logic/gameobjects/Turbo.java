package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Turbo extends GameObject{

    private static int boost;

    public static final String INFO = "[TURBO] pushes the car: 3 columns\n";

    public Turbo(Game game, int x, int y) {
        super(game, x, y);
        boost = 3;
        symbol = ">>>";
    }

    @Override
    public boolean doCollision() {
        return false;
    }

    @Override
    public boolean receiveCollision(Player player) {
        player.noCollisionMovement(boost);
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

    }

    @Override
    public void onDelete() {

    }
}
