package todo;

public class Thunder implements InstantAction{
    public static int x;
    public static int y;

    @Override
    public void execute(Game game) {
        x = game.getXPlayer() + game.getRandomXInVisibility();
        y = game.getRandomY();
        GameObject o = game.getObjectInPos(x, y);
        if(o != null) {
            System.out.println("hit object " + o.toString());
            o.receiveThunder();
        }
    }
}
