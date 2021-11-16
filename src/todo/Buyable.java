package todo;

public interface Buyable {

    public int cost();
    public default boolean buy(Game game){ // TODO preguntar si esto es legal
        return game.tryToBuy(cost());
    };

}