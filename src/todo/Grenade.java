package todo;

public class Grenade extends GameObject{

    static String INFO = "[GRENADE] Explodes in 3 cycles, harming everyone around\n";
    private static final int radio = 1;
    public Grenade(Game game, int x, int y) {
        super(game, x, y);
        hp = 2;
        symbol = "ð[3]";
    }


    @Override
    public boolean doCollision() {
        return false;
    }

    @Override
    public boolean receiveCollision(Player player) {
        return false;
    }

    @Override
    public boolean receiveShot() {
        return false;
    }

    @Override
    public boolean receiveExplosion() {
        return false;
    }

    @Override
    public void onEnter() {
        numObjects++;
    }

    @Override
    public void update() {
        hp--;
        if(hp == 0){

            for(int i= x-radio; i <= x+radio; i++){
                for(int j = y-radio; j <= y +radio;j++){
                    Collider objeto = game.getObjectInPos(i,j); // Collider
                    if(objeto != null){
                        objeto.receiveExplosion();
                    }

                }
            }
        }
        symbol = "ð["+ (hp + 1)+"]";
    }

    @Override
    public void onDelete() {
        numObjects--;
    }
}
