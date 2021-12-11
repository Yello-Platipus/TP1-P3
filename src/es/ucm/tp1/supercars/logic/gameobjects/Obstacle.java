package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Obstacle extends GameObject{

	protected static int numObs = 0;
	public static final String INFO = "[Obstacle] hits car\n";

	public Obstacle(Game game, int x, int y){
		super(game, x, y);
		symbol = "░";
	}

	public static int getNumObstacles(){
		return numObs ;
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
	public boolean receiveShot() {
		hp--;
		return true;
	}

	@Override
	public boolean receiveThunder() {
		System.out.println(" -> " + symbol);
		die();
		return true;
	}

	public boolean receiveExplosion(){
		die();
		return true;
	}

	@Override
	public void onEnter() {
		numObs++;
	}

	@Override
	public void update() {

	}

	@Override
	public void onDelete() {
		numObs--;
	}
}
