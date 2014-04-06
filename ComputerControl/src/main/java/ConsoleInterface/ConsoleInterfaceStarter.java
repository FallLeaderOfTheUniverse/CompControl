package ConsoleInterface;

/**
 * Created by spier on 4/6/14.
 */
public class ConsoleInterfaceStarter implements Runnable{

    @Override
    public void run() {

        Console console = new Console();
        Command command = new Command();

        while (true) {
            command.runCommand(console.read());
        }
    }
}
