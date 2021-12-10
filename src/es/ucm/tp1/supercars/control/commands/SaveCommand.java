package es.ucm.tp1.supercars.control.commands;


import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveCommand extends Command{

    private static final String NAME = "save";

    private static final String DETAILS = "sa[v]e <filename>";

    private static final String SHORTCUT = "v";

    private static final String HELP = "Save the state of the game to a file.";

    String nameFile;

    public SaveCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    protected Command parse(String[] words) throws CommandParseException {
        if (matchCommandName(words[0])) {
            if(words.length == 2){
                nameFile = words[1];
                return this;
            }

            else {
                throw new CommandParseException(String.format("[ERROR]: Command %s: %s", NAME, INCORRECT_NUMBER_OF_ARGS_MSG));
            }
        }
        return null;
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        try{
            BufferedWriter save = new BufferedWriter(new FileWriter(nameFile + ".txt"));
            save.write("Super cars 3.0\n\n");
            save.write(game.serializer());
            save.close();
        }
        catch (IOException ioe){
            throw new CommandExecuteException(ioe.getMessage());
        }
        System.out.println("Game successfully saved to file " + nameFile + ".txt");
        return false;
    }
}
