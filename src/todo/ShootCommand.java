package todo;

public class ShootCommand extends Command{
    public ShootCommand(String name, String shortcut, String details, String help) {
        super(name, shortcut, details, help);
    }


    @Override
    public boolean execute(Game game) {

        return false;
    }
}
