package es.ucm.tp1.supercars.control.commands;
import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DumpCommand extends Command{
    private static final String NAME = "dump";

    private static final String DETAILS = "[d]ump";

    private static final String SHORTCUT = "d";

    private static final String HELP = "Shows the content of a saved file";

    public DumpCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    String nameFile;

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
            BufferedReader save = new BufferedReader(new FileReader(nameFile+".txt"));

            int i = save.read();
            while(i!=-1){
                System.out.print((char)i);
                i=save.read();
            }
            save.close();
        }
        catch (IOException ioe){
            throw new CommandExecuteException(ioe.getMessage());
        }

        return true;
    }
}
