package todo;

public class Player extends GameObject{

	private int numCoins;
	static String INFO = "[Car] the racing car\n";

	public Player(Game game){
		super(game, 0, game.getWidth() / 2);
		symbol = ">";
		numCoins = 5;
	}

	public boolean hasArrived(){
		return x >= game.getLength() + 1;
	}
	public int getNumCoins(){
		return this.numCoins;
	}
	public void addCoin(int coinValue){
		numCoins+=coinValue;
	}
	public boolean decreaseCoins(int coins){
		if(numCoins >= coins){
			numCoins -= coins;
			return true;
		}
		return false;
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
		hp = 0;
		symbol = "@";
	}

	public void penalty(){
		numCoins = 0;
	}

	public void pickUpTurbo(int boost){
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