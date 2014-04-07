package Busines;

import java.io.IOException;

/**
 * Created by spier on 4/7/14.
 */
public class CommandThread implements Runnable {
    private String command;

    public CommandThread(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        CommandManager bash = new CommandManager(command);
        System.out.println(command + " from thread");
        try {
            bash.runScript();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
