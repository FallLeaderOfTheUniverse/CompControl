package Busines;

/**
 * Created by spier on 4/7/14.
 */
public class Command {
    String command;

    public Command(String command) {
        this.command = command;
    }

    public void makeCommand(String commandType) throws Exception {
        if (!commandType.equals("bash") || !commandType.equals("echo")) {
            throw new Exception("wrong command");
        }

        String s = new String (commandType + command);

        ServerCommunication server = new ServerCommunication();
        //TODO: отправлять команду на сервер
    }


}
