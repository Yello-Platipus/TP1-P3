package todo;

public class Shot implements InstantAction{

    @Override
    public void execute(Game game) {
        int i = 0;
        while(!game.getObjectInPos(game.getXPlayer() + i, game.getYPlayer()).receiveShot()){
            i++;
        }
    }
}
