package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.control.commands.SerializeCommand;
import es.ucm.tp1.supercars.control.exceptions.InvalidPositionException;
import es.ucm.tp1.supercars.control.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;
import es.ucm.tp1.supercars.logic.actions.InstantAction;
import es.ucm.tp1.supercars.logic.gameobjects.Player;
import es.ucm.tp1.supercars.view.GameSerializer;

import java.util.Random;

public class Game {

	static String FINISH_LANE = "¦";

	private Level level;
	private Player player;
	boolean exit;
	private long seed;
	private int cycles;
	private long startTime;
	private long currentLevelRecord;
	private boolean modoTest;
	private Random random;
	private GameObjectContainer container;
	private GameSerializer serializer;

	public Game(long seed, Level level){
		reset(seed, level);
		modoTest = (level == Level.TEST);
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

	public void moveUp() {
		player.moveUp();
	}
	public void moveDown() {
		player.moveDown();
	}
	public void move() {
		player.update();
	}
	public void update(){
		container.updateObjects();
		GameObjectGenerator.generateRuntimeObjects(this);
		addCycles(1);
		updateDeadObjects();
	}
	public void updateDeadObjects(){
		container.deleteDeadObjects();
	}
	public void addObjectContainer(GameObject o){container.addObject(o);}
	public void receivePrize(int prize){
		player.addCoin(prize);
	}

	public String positionToString(int x, int y){
		StringBuilder icono = new StringBuilder();
		GameObject object = getObjectInPos(x,y);
		if(player.isInPosition(x, y))
			icono.append(player.getSymbol() + " ");
		if(object != null)
			icono.append(container.getStringInPos(x, y) + " ");
		else if(x == getLength())
			icono.append(FINISH_LANE + " ");
		return icono.toString().trim();
	}

	public void toggleTest() {
		modoTest = true;
	}
	public void togglePrematureExit(){
		exit = true;
	}

	public int getRandomY(){
		return (int)(random.nextDouble() * level.getWidth());
	}
	public int getRandomXInVisibility(){
		return (int)(random.nextDouble() * level.getVisibility() );
	}
	public void tryToAddObject(GameObject object, double frequency){
		if (random.nextDouble() < frequency)
			addObjectContainer(object);
	}

	public GameObject getObjectInPos(int x, int y){
		return container.getObjectInPos(x, y);
	}
	public void forceAddObject(GameObject o) {
		container.clearRow((player.getX() + level.getVisibility() - 1));
		updateDeadObjects();
		addObjectContainer(o);
	}
	public String serializePosition(int x, int y){
		return container.serialization(x, y);
	}
	public String serializer(){
		return serializer.serialize();
	}

	public void forceAdvancedObject(int command) {
		GameObjectGenerator.forceAdvancedObject(this, command, getXPlayer() + getVisibility() - 1);
	}

	public void outOfBounds(int x, int y)throws InvalidPositionException {
		if(!((x >= getXPlayer() && x < (getXPlayer()+ getVisibility())) && (y >= 0 && y < getWidth()) && getObjectInPos(x, y) == null)){
			throw new InvalidPositionException("Invalid position.\n");
		}
	}

	public void reset(long seed, Level level){
		this.seed = seed;
		this.level = level;
		cycles = 0;
		startTime = System.currentTimeMillis();
		random = new Random(seed);
		container = new GameObjectContainer();
		serializer = new GameSerializer(this);
		player = new Player(this);
		exit = false;
		GameObjectGenerator.reset(level);
		GameObjectGenerator.generateGameObjects(this, level);
	}

	public void executeInstantAction(InstantAction action){
		action.execute(this);
	}

	public void clear() {
		container.clear();
	}

	public void punishPlayer(){
		player.penalty();
	}
	public void tryToBuy(int coins)throws NotEnoughCoinsException {
		try{ player.decreaseCoins(coins);}
		catch (NotEnoughCoinsException ex){
			throw new NotEnoughCoinsException(ex.getMessage());
		}
	}

	public void saveRecord(){

	}
	public void initRecord(){

	}
	public String getRecord(){
		StringBuilder ret = new StringBuilder(level.toString() + " record is ");
		ret.append(currentLevelRecord / 100 + " s\n");
		return ret.toString();
	}
}