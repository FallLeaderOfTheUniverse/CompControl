package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by spier on 4/6/14.
 */

//TODO: обеспечить устойчивость связи
public class ClientStarter implements Runnable{
    String ip = null;
    private String command;

    public ClientStarter(String ip, String command) {
        this.ip = ip;
        this.command = command;
    }

    @Override
    public void run() {
        Socket fromServer = null;
        BufferedReader in = null;
        PrintWriter out = null;
        InetAddress address = null;

        try {
            address = InetAddress.getByName(ip);
            fromServer = new Socket(address, 4444);
            in = new BufferedReader(new InputStreamReader(fromServer.getInputStream()));
            out = new PrintWriter(fromServer.getOutputStream(), true);

            String fuser, fserver;

            for (int i = 0; i < 10; i++) {
                out.println(command);
            }
            fserver = in.readLine();
            System.out.println(fserver);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
                fromServer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
