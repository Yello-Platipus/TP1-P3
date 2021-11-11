package todo;

public interface Buyable {

    public int cost();
    public default void buy(Game game){

    };

}