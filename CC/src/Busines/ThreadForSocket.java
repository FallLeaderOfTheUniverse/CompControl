package Busines;

import android.util.Log;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by spier on 4/7/14.
 */
public class ThreadForSocket implements Runnable {
    private final String IP = "localhost";
    private final Integer PORT = 4444;
    private String command;

    public ThreadForSocket(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        ServerCommunication serverCommunication = new ServerCommunication();
        Log.i("ThreadForSocket", command);
        try {
            InetAddress ip = InetAddress.getByName(IP);
            serverCommunication.sendCommand(command, ip, PORT);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
