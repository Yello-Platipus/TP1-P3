package todo;

public interface Buyable {

    public int cost();
    public default boolean buy(Game game){
        if(game.tryToBuy(cost())){
            return true;
        }
        return false;
    };

}