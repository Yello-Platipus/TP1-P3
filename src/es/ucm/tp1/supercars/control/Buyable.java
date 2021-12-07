package es.ucm.tp1.supercars.control;

import es.ucm.tp1.supercars.control.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.logic.Game;

public interface Buyable {

    public int cost();
    public default void buy(Game game) throws NotEnoughCoinsException {

        try{
            game.tryToBuy(cost());
        }
        catch (NotEnoughCoinsException ex){
            throw new NotEnoughCoinsException(ex.getMessage());
        }

    };

}