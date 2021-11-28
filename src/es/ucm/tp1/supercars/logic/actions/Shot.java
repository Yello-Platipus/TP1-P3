package es.ucm.tp1.supercars.logic.actions;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class Shot implements InstantAction{

    @Override
    public void execute(Game game) {
        int i = 0;
        boolean hasHit = false;
        GameObject object;
        while(!hasHit && i < game.getVisibility()){
            object = game.getObjectInPos(game.getXPlayer() + i, game.getYPlayer());
            if(object != null && object.receiveShot())
                hasHit = true;
            else
                i++;
        }
    }
}
