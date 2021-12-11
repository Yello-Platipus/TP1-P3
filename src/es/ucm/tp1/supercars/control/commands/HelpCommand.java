package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class HelpCommand extends Command {

	private static final String NAME = "help";

	private static final String DETAILS = "[h]elp";

	private static final String SHORTCUT = "h";

	private static final String HELP = "show this help";

	public HelpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		StringBuilder buffer = new StringBuilder("Available commands:\n");
		Command[] commands = getAvailableCommands();
		for(Command x:commands){
			buffer.append(x.getDetails() + ": " + x.getHelp() + "\n");
		}
		System.out.print(buffer.toString());
		return false;
	}

}
