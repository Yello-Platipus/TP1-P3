package es.ucm.tp1.supercars.logic.actions;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class Thunder implements InstantAction{
    private static int x;
    private static int y;

    private static boolean hasHit = false;

    @Override
    public void execute(Game game) {
        x = game.getRandomXInVisibility();
        y = game.getRandomY();
        GameObject o = game.getObjectInPos(game.getXPlayer() + x, y);
        System.out.print("Thunder hit position: (" + x + " , " + y + ")");
        if(o != null) {
            hasHit = o.receiveThunder();
           if(!hasHit){
               System.out.println();
           }
        }
        else {
            hasHit = false;
            System.out.println();
        }
    }
}
