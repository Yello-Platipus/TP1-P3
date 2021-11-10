package todo;

public class SuperCoin extends GameObject{

    private static int numSuperCoins = 0;
    private final int value;
    static String INFO = "[SUPERCOIN] gives 1000 coins\n"; // TODO

    public SuperCoin(Game game, int x, int y){
        super(game, x, y);
        symbol = "$";
        value = 1000;
    }

    public static boolean hasSuperCoins(){ return numSuperCoins > 0;}

    public static void reset(){
        numSuperCoins = 0;
    }

    @Override
    public boolean doCollision() {
        return false;
    }

    @Override
    public boolean receiveCollision(Player player) {
        player.addCoin(value);
        hp = 0;
        return true;
    }

    @Override
    public boolean receiveShot() {
        return false;
    }

    @Override
    public void onEnter() {
        numSuperCoins++;
        numObjects++;
    }

    @Override
    public void update() {/*MUDA MUDA MUDA MUDA MUDA MUDA*/}

    @Override
    public void onDelete() {
        numSuperCoins--;
        numObjects--;
    }
}
