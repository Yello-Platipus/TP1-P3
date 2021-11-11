package todo;

public class Wall extends GameObject{

    private static final int coinsOnDestroy = 5;
    private static int numWalls = 0;
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
                return null;
        }
    }

    @Override
    public boolean doCollision() {
        return false;
    }

    @Override
    public boolean receiveCollision(Player player) {
        player.zeMato();
        return true;
    }

    @Override
    public boolean receiveShot() {
        hp--;
        return true;
    }

    @Override
    public boolean receiveExplosion() {
        hp--;
        return true;
    }

    @Override
    public void onEnter() {
        numWalls++;
        numObjects++;
    }

    @Override
    public void update() {

    }

    @Override
    public void onDelete() {
        game.receivePrize(coinsOnDestroy);
        numWalls--;
        numObjects--;
    }
}
