package todo;

public interface Collider {

	boolean doCollision();
	boolean receiveCollision(Player player);
	boolean receiveShot();
	boolean receiveExplosion();
	void receiveWave();
}
