package Busines;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by spier on 4/7/14.
 */
public class ServerCommunication {

    public String sendCommand(String command, InetAddress ip, Integer port) {
        //TODO: убрать это тупую передачу параметров

        BufferedReader in = null;
        PrintWriter out = null;
        try {
            Socket socket = SingletonSocket.getInstance(ip, port);

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String fromServer = null;
            do {
                out.println(command);
                fromServer = in.readLine();
            } while (!fromServer.equals("accept"));


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
