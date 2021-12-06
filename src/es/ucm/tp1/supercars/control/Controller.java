package es.ucm.tp1.supercars.control;

import es.ucm.tp1.supercars.control.commands.Command;
import es.ucm.tp1.supercars.control.exceptions.GameException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.view.GamePrinter;

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
			try{
			Command command = Command.getCommand(parameters);
				refreshDisplay = command.execute(game);
			}
			catch (GameException ex){
				System.out.format(ex.getMessage() + " %n %n");
			}


		}
		if (refreshDisplay) {
			printGame();
		}
		printEndMessage();
	}
}
