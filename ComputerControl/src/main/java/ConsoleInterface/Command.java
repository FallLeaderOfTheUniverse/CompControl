package ConsoleInterface;

import org.omg.CORBA.CODESET_INCOMPATIBLE;

/**
 * Created by spier on 4/6/14.
 */
class Command {

    public void runCommand(String command) {
        if (command.equals("exit")) {
            System.exit(-1);
        }
        if (command.equals("stop")) {
            System.out.println("stop command");
        }
        if (command.equals("start")) {
            System.out.println("start command");
        }
    }
}
