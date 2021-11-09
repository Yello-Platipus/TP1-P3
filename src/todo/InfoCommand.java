package todo;

public class InfoCommand extends Command {

	private static final String NAME = "info";

	private static final String DETAILS = "[i]nfo";

	private static final String SHORTCUT = "i";

	private static final String HELP = "prints gameobject info";

	public InfoCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		StringBuilder str = new StringBuilder("Available objects:\n");
		str.append(Player.INFO);
		str.append(Coin.INFO);
		str.append(Obstacle.INFO);
		System.out.print(str.toString());
		return false;
	}

}