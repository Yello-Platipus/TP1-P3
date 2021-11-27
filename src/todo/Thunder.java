package todo;

public class Thunder implements InstantAction{
    private static int x;
    private static int y;

    private static boolean hasHit = false;
    private static String hitObject;

    @Override
    public void execute(Game game) {
        x = game.getRandomXInVisibility();
        y = game.getRandomY();
        GameObject o = game.getObjectInPos(game.getXPlayer() + x, y);
        if(o != null) {
            hitObject = o.getSymbol();
            hasHit = o.receiveThunder();
        }
        else
            hasHit = false;
        System.out.print(thunderHit()); //daniiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii
    }

    public static String thunderHit(){
        String ret = "Thunder hit position: (" + x + " , " + y + ")";
        if(hasHit)
            return ret + " -> " + hitObject + "\n";
        else
            return ret + "\n";
    }
}
