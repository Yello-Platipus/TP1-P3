package todo;

public class SuperCoin extends Coin{

    private static int numSuperCoins = 0;
    private static final int value = 1000;
    static String INFO = "[SUPERCOIN] gives 1000 coins\n";

    public SuperCoin(Game game, int x, int y){
        super(game, x, y);
        symbol = "$";
    }

    public static boolean hasSuperCoins(){
        return numSuperCoins > 0;
    }

    public static void reset(){
        numSuperCoins = 0;
    }

    @Override
    public boolean receiveCollision(Player player) {
        player.addCoin(value);
        hp--;
        return true;
    }

    @Override
    public void onEnter() {
        numSuperCoins++;
        numObjects++;
    }

    @Override
    public void onDelete() {
        numSuperCoins--;
        numObjects--;
    }
}
