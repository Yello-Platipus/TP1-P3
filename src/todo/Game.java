package todo;

import java.util.Random;

public class Game {

	static String FINISH_LANE = "¦";

	private Level level;
	private Player player;
	boolean exit;
	private long seed;
	private int cycles;
	private long startTime;
	private boolean modoTest;
	private Random random;
	private GameObjectContainer container;

	public Game(long seed, Level level){
		this.seed = seed;
		this.level = level;
		cycles = 0;
		startTime = System.currentTimeMillis();
		random = new Random(seed);
		modoTest = (level == Level.TEST);
		container = new GameObjectContainer();
		player = new Player(this);
		exit = false;
		GameObjectGenerator.generateGameObjects(this, level);
	}

	public Level getLevel(){
		return level;
	}
	public long getSeed(){
		return seed;
	}
	public int getWidth(){
		return level.getWidth();
	}
	public int getLength(){
		return level.getLength();
	}
	public int getVisibility() {
		return level.getVisibility();
	}
	public int getXPlayer() {
		return player.getX();
	}
	public int getYPlayer(){
		return player.getY();
	}
	public int getNumCoins(){
		return player.getNumCoins();
	}
	public int getCycles(){
		return cycles;
	}
	public void addCycles(int sum){
		cycles += sum;
	}
	public long getStartTime(){
		return startTime;
	}
	public boolean getModoTest(){
		return modoTest;
	}
	public boolean isFinished(){
		return (hasCrashed() || player.hasArrived() || exit);
	}

	public boolean hasCrashed(){
		return !player.isAlive();
	}

	public boolean moveUp() {
		return player.moveUp();
	}
	public boolean moveDown() {
		return player.moveDown();
	}
	public void move() {
		player.update();
	}
	public void update(){
		addCycles(1);
		deleteDeadObjects();
	}
	public void receivePrize(int prize){
		player.addCoin(prize);
	}

	public String positionToString(int x, int y){
		String icono = "";
		GameObject object = getObjectInPos(x,y);
		if(player.isInPosition(x, y))
			icono = player.symbol;
		else if(object != null)
			icono = object.getSymbol();

		else if(x == getLength())
			icono = FINISH_LANE;
		return icono;
	}

	public void toggleTest() {
		modoTest = true;
	}
	public void togglePrematureExit(){
		exit = true;
	}

	public int getRandomLane(){
		return (int)(this.random.nextDouble() * level.getWidth());
	}
	public void tryToAddObject(GameObject object, double frequency){
		if (random.nextDouble() < frequency)
			container.addObject(object);
	}

	public void deleteDeadObjects(){
		container.updateObjects();
	}
	public GameObject getObjectInPos(int x, int y){
		return container.getObjectInPos(x, y);
	}
	public void forceAddObject(GameObject o) {
		container.clearRow(o.getX());
		container.updateObjects();
		container.addObject(o);
	}

	public void reset(long seed, Level level){
		this.seed = seed;
		this.level = level;
		cycles = 0;
		startTime = System.currentTimeMillis();
		random = new Random(seed);
		modoTest = (level == Level.TEST);
		container = new GameObjectContainer();
		player = new Player(this);
		GameObjectGenerator.reset(level);
		GameObjectGenerator.generateGameObjects(this, level);
	}

	public void executeInstantAction(InstantAction action){
		action.execute(this);
	}

	public void forceAdvancedObject(int command) {
		GameObjectGenerator.forceAdvancedObject(this, command, getXPlayer() + getVisibility() - 1);
	}

	public void clear() {
		container.clear();
	}

	public void pushSeenObjects() {
		container.pushSeenObjects(getXPlayer(), getXPlayer() + getVisibility() - 1);
	}
	public void createGrenade(GameObject grenade,int x, int y){

		if(x >= 0 && x <  getVisibility() && getObjectInPos(x + getXPlayer(),y) == null) {
			container.addObject(grenade);
		}
	}
}