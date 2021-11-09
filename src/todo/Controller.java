package todo;

import java.util.Scanner;

public class Controller {

	private static final String PROMPT = "Command > ";

	private Game game;

	private Scanner scanner;
	
	private GamePrinter printer;

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		printer = new GamePrinter(game);
	}

	public void printGame() {
		System.out.println(printer);
	}

	public void printEndMessage() {printer.endMessage();}

	public void run() throws InterruptedException {
		boolean refreshDisplay = true;
		while (!game.isFinished()){
			if (refreshDisplay) {
				printGame();
			}
			refreshDisplay = false;
			System.out.println(PROMPT);
			String s = scanner.nextLine();
			String[] parameters = s.toLowerCase().trim().split(" ");
			System.out.println("[DEBUG] Executing: " + s);
			Command command = Command.getCommand(parameters);
			if (command != null) {
				refreshDisplay = command.execute(game);
			}
		}
		if (refreshDisplay) {
			printGame();
		}
		printEndMessage();
	}
}
