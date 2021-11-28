package todo;

public class Wall extends Obstacle{

    private static final int coinsOnDestroy = 5;
    private boolean explosion = false;
    static String INFO = "[WALL] hard obstacle\n";

    public Wall(Game game, int x, int y) {
        super(game, x, y);
        hp = 3;
    }

    @Override
    protected String getSymbol(){
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

    public static void reset(){

    }

    public void onEnter() {

        numObs++;
        numObjects++;
    }

    @Override
    public boolean receiveExplosion(){
        hp = 0;
        explosion = true;
        return true;
    }

    @Override
    public void onDelete() {
        if(!explosion){
            game.receivePrize(coinsOnDestroy);
        }
        numObs--;
        numObjects--;
    }
}