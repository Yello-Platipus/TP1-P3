package todo;

public class GrenadeCommand extends Command{

    public GrenadeCommand(String name, String shortcut, String details, String help) {
        super(name, shortcut, details, help);
    }

    @Override
    public boolean execute(Game game) {
        return false;
    }
}
