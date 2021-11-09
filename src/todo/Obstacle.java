package todo;

public class Obstacle extends GameObject{

	private static int numObs = 0;
	static String INFO = "[Obstacle] hits car\n";

	public Obstacle(Game game, int x, int y){
		super(game, x, y);
		symbol = "░";
	}

	public static int getNumObstacles(){
		return numObs;
	}

	public static void reset() {
		numObs = 0;
	}

	@Override
	public boolean doCollision() {
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.zeMato();
		return true;
	}

	@Override
	public boolean receiveShoot() { // TODO
		return false;
	}

	@Override
	public void onEnter() {
		numObs++;
		numObjects++;
	}

	@Override
	public void update() {

	}

	@Override
	public void onDelete() {
		numObs--;
		numObjects--;
	}
}
