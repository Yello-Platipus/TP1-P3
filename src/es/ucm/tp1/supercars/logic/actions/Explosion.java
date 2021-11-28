package es.ucm.tp1.supercars.logic.actions;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class Explosion implements InstantAction {
    private static final int radio = 1;
    private int x;
    private int y;

    public Explosion(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute(Game game) {
        for(int i = x - radio; i <= x + radio; i++) {
            for (int j = y - radio; j <= y + radio; j++) {
                Collider objeto = game.getObjectInPos(i, j); // Collider
                if (objeto != null)
                    objeto.receiveExplosion();
            }
        }

    }
}
