package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Wall extends Obstacle{

    private static final int coinsOnDestroy = 5;
    private boolean explosion = false;
    public static String INFO = "[WALL] hard obstacle\n";

    public Wall(Game game, int x, int y) {
        super(game, x, y);
        hp = 3;
    }

    @Override
    public String getSymbol(){
        switch(hp) {
            case 3:
                return "█";
            case 2:
                return "▒";
            case 1:
                return "░";
            default:
                return "";
        }
    }

    @Override
    public boolean receiveExplosion(){
        die();
        explosion = true;
        return true;
    }

    @Override
    public void onDelete() {
        if(!explosion){
            game.receivePrize(coinsOnDestroy);
        }
        numObs--;
    }
}