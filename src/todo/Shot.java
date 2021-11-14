package todo;

public class Shot implements InstantAction{

    @Override
    public void execute(Game game) {
        int i = 0;//AAAA 1? xd
        boolean hasHit = false;
        GameObject object;
        while(!hasHit && i < game.getVisibility()){
            object = game.getObjectInPos(game.getXPlayer() + i, game.getYPlayer());
            if(object != null && object.receiveShot())
                hasHit = true;
            else
                i++;
        }
    }
}
