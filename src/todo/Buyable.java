package todo;

public interface Buyable {

    public int cost();
    public default boolean buy(Game game){
        return game.tryToBuy(cost());
    };

}