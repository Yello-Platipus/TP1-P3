package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.control.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class Player extends GameObject{

	private int numCoins;
	public static final String INFO = "[Car] the racing car\n";

	public Player(Game game){
		super(game, 0, game.getWidth() / 2);
		symbol = ">";
		numCoins = 5;
	}

	public boolean hasArrived(){
		return x >= game.getLength() + 1;
	}
	public int getNumCoins(){
		return numCoins;
	}
	public void addCoin(int coinValue){
		numCoins+=coinValue;
	}
	public void decreaseCoins(int coins)throws NotEnoughCoinsException {

		if(numCoins >= coins){
			numCoins -= coins;
		}
		else{
			throw new NotEnoughCoinsException("Not enough coins\n");
		}
	}

	public void moveUp(){
		if(!doCollision()){
			if((y > 0))
				y--;
			x++;
			doCollision();
		}
	}

	public void moveDown(){
		if(!doCollision()){
			if(y < game.getWidth() - 1)
				y++;
			x++;
			doCollision();
		}
	}

	public void zeMato(){
		die();
		symbol = "@";
	}

	@Override
	public String serialize(){
		StringBuilder ret = new StringBuilder(toString());
		if(isInPosition(x, y)){
			ret.append(" (" + x + ", " + y + ")\n");
		}
		return ret.toString();
	}

	public void penalty(){
		numCoins = 0;
	}

	public void noCollisionMovement(int boost){
		x += boost;
	}

	@Override
	public boolean doCollision() {
		Collider objectCollision = game.getObjectInPos(x, y);
		if (objectCollision != null) {
			return objectCollision.receiveCollision(this);
		}
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
	public void receiveWave(){

	}

	@Override
	public boolean receiveThunder() {
		return false;
	}

	@Override
	public void onEnter() {

	}

	@Override
	public void update() {
		if(!doCollision()){
			x++;
			doCollision();
		}
	}

	@Override
	public void onDelete() {

	}
}