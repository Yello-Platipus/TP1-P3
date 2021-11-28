package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public abstract class GameObject implements Collider {

	protected int x, y, hp;

	protected Game game;

	protected String symbol;

	public GameObject(Game game, int x, int y) {
		this.x = x;
		this.y = y;
		this.game = game;
		hp = 1;
	}

	public String getSymbol() {
		return symbol;
	}

	@Override
	public String toString() {
		if (isAlive()) {
			return getSymbol();
		}
		return "";
	}

	public boolean isInPosition(int x, int y) {
		return this.y == y && this.x == x;
	}

	public int getX() {
		return x;
	}
	public void increaseX(){
		x++;
	}
	public int getY() {
		return y;
	}

	public boolean isAlive() {
		return hp > 0;
	}

	public abstract void onEnter();

	public abstract void update();

	public abstract void onDelete();

	@Override
	public boolean receiveExplosion(){
		return receiveShot();
	}

	@Override
	public void receiveWave() {
		x++;
	}

	public void die(){
		hp = 0;
	}
}


