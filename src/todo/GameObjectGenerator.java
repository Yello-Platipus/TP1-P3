package todo;

public class GameObjectGenerator {

	public static void generateGameObjects(Game game, Level level) {
		for(int x = game.getVisibility() /2; x < game.getLength(); x ++) {
			game.tryToAddObject(new Obstacle(game, x, game.getRandomLane()), level.getObstacleFrequency());
			game.tryToAddObject(new Coin(game, x, game.getRandomLane()), level.getCoinFrequency());
			if (level.hasAdvancedObjects()) {
				game.tryToAddObject(new Wall(game, x, game.getRandomLane()), level.getAdvObjFrequency());
				game.tryToAddObject(new Turbo(game, x, game.getRandomLane()), level.getAdvObjFrequency());
				if (!SuperCoin.hasSuperCoins())
					game.tryToAddObject(new SuperCoin(game, x, game.getRandomLane()), level.getAdvObjFrequency());
				game.tryToAddObject(new Truck(game, x, game.getRandomLane()), level.getAdvObjFrequency());
				game.tryToAddObject(new Pedestrian(game, x, 0), level.getAdvObjFrequency());
			}
		}
	}

	public static void reset(Level level) {
		Obstacle.reset();
		Coin.reset();
	}

	public static void generateRuntimeObjects(Game game) {
		if (game.getLevel().hasAdvancedObjects()) {
			game.executeInstantAction(new Thunder());
		}
	}

	public static void forceAdvancedObject(Game game, int id, int x) {
		GameObject o = null;
		switch (id) {
			case 1:
				o = new Wall(game, x, game.getRandomLane());
				break;
			case 2:
				o = new Turbo(game, x, game.getRandomLane());
				break;
			case 3:
				o = new SuperCoin(game, x, game.getRandomLane());
				break;
			case 4:
				o = new Truck(game, x, game.getRandomLane());
				break;
			case 5:
				o = new Pedestrian(game, x, 0);
				break;
		}
		game.forceAddObject(o);
	}

}
