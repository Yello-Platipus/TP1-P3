package todo;

public class GamePrinter {

	private static final String SPACE = " ";

	private static final String ROAD_BORDER_PATTERN = "═";

	private static final String LANE_DELIMITER_PATTERN = "─";

	private static final int CELL_SIZE = 7;

	private static final int MARGIN_SIZE = 2;

	private String indentedRoadBorder;

	private String indentedLanesSeparator;

	private String margin;

	
	private static final String CRASH_MSG = String.format("Player crashed!%n");

	private static final String WIN_MSG = String.format("Player wins!%n");

	private static final String DO_EXIT_MSG = "Player leaves the game"; 
	
	private static final String GAME_OVER_MSG = "[GAME OVER] "; 
	
	public String newLine; 

	protected Game game;

	public GamePrinter(Game game) {
		this.game = game;
	}
	private void printRoad(){
		margin = StringUtils.repeat(SPACE, MARGIN_SIZE);

		String roadBorder = ROAD_BORDER_PATTERN + StringUtils.repeat(ROAD_BORDER_PATTERN, (CELL_SIZE + 1) *  game.getVisibility());
		indentedRoadBorder = String.format("%n%s%s%n", margin, roadBorder);

		String laneDelimiter = StringUtils.repeat(LANE_DELIMITER_PATTERN, CELL_SIZE);
		String lanesSeparator = SPACE + StringUtils.repeat(laneDelimiter + SPACE,  game.getVisibility() - 1) + laneDelimiter + SPACE;

		indentedLanesSeparator = String.format("%n%s%s%n", margin, lanesSeparator);
		newLine =  System.getProperty("line.separator");


		newLine =  System.getProperty("line.separator");
	}
	public String getTime(){
		String ret = "";

		if(game.getCycles() == 0)
			ret = "\n"+ "Elapsed Time: 0.00 s";
		else
			ret = ("\n"+ "Elapsed Time: " + ((double)System.currentTimeMillis() - this.game.getStartTime()) / 1000) + " s";

		return ret;
	}

	public String getInfo() {
		StringBuilder ret = new StringBuilder();
		ret.append("Distance: " + (game.getLength() - game.getXPlayer()) + "\n");
		ret.append("Coins: " + game.getNumCoins() + "\n");
		ret.append("Cycle: " + game.getCycles() + "\n");
		ret.append("Total obstacles: " + Obstacle.getNumObstacles() + "\n");
		ret.append("Total coins: " + Coin.getNumCoins());
		if(SuperCoin.hasSuperCoins())
			ret.append("Supercoin is present\n");
		if(!this.game.getModoTest())
			ret.append(getTime());

		return ret.toString();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		// Game Status
		printRoad();

		str.append(getInfo());

		// Paint game

		str.append(indentedRoadBorder);

		String verticalDelimiter = SPACE;

		for (int y = 0; y < game.getWidth(); y++) {
			str.append(this.margin).append(verticalDelimiter);
			for (int x = game.getXPlayer(); x < (game.getVisibility() + game.getXPlayer()); x++) {
				str.append(StringUtils.centre(game.positionToString(x, y), CELL_SIZE)).append(verticalDelimiter);
			}
			if (y <  game.getWidth() - 1) {
				str.append(this.indentedLanesSeparator);
			}
		}
		str.append(this.indentedRoadBorder);

		return str.toString();
	}


	public void endMessage(){
		System.out.print(GAME_OVER_MSG);
		
		if(game.hasCrashed())
			System.out.println(CRASH_MSG);
		else if(game.getXPlayer() == game.getLength()+1)
			System.out.println(WIN_MSG);
		else
			System.out.println(DO_EXIT_MSG);
	}

	public static void printGameInfo(){
		StringBuilder str = new StringBuilder("Available objects:\n");
		str.append(Player.INFO);
		str.append(Coin.INFO);
		str.append(Obstacle.INFO);
		str.append(Grenade.INFO);
		str.append(Wall.INFO);
		str.append(Turbo.INFO);
		str.append(SuperCoin.INFO);
		str.append(Truck.INFO);
		str.append(Pedestrian.INFO);
		System.out.print(str.toString());
	}
}
