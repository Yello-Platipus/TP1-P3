package todo;

public class SuperCoin extends Coin{

    private static boolean hasSuperCoin = false;
    private static final int value = 1000;
    static String INFO = "[SUPERCOIN] gives 1000 coins\n";

    public SuperCoin(Game game, int x, int y){
        super(game, x, y);
        symbol = "$";
    }

    public static boolean hasSuperCoins(){
        return hasSuperCoin;
    }

    public static void reset(){
        hasSuperCoin = false;
    }

    @Override
    public boolean receiveCollision(Player player) {
        player.addCoin(value);
        hp--;
        return false;
    }

    @Override
    public void onEnter() {
        hasSuperCoin = true;
        numObjects++;
    }

    @Override
    public void onDelete() {
        hasSuperCoin = false;
        numObjects--;
    }
}
