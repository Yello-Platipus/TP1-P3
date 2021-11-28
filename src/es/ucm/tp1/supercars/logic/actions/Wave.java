package es.ucm.tp1.supercars.logic.actions;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class Wave implements InstantAction{
    @Override
    public void execute(Game game) {
        for (int i = game.getXPlayer() + game.getVisibility() - 1; i >= game.getXPlayer(); i--) {
            for (int j = game.getWidth(); j >= 0; j--) {
                GameObject o = game.getObjectInPos(i, j);
                if (o != null && game.getObjectInPos(o.getX() + 1, o.getY()) == null)
                    o.receiveWave();
            }
        }
    }
}
