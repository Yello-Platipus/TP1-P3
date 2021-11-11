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

	public boolean moveUp(){
		if(y > 0) {
			y--;
			update();
			return true;
		}
		else
			return false;
	}

	public boolean moveDown(){
		if(y < game.getWidth() - 1) {
			y++;
			update();
			return true;
		}
		else
			return false;
	}

	public void zeMato(){
		hp = 0;
		symbol = "@";
	}

	public void pickUpTurbo(int boost){
		x += boost;
	}

	@Override
	public boolean doCollision() {
		Collider objectCollision = game.getObjectInPos(x, y);
		if (objectCollision != null) {
			objectCollision.receiveCollision(this);
			return true;
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
	public boolean receiveExplosion() {
		return false;
	}

	@Override
	public void onEnter() {

	}

	@Override
	public void update() {
		x++;
		doCollision();
	}

	@Override
	public void onDelete() {

	}
}