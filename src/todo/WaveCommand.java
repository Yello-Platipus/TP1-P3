package todo;

public class WaveCommand extends Command{

    public WaveCommand(String name, String shortcut, String details, String help) {
        super(name, shortcut, details, help);
    }

    @Override
    public boolean execute(Game game) {
        return false;
    }
}
