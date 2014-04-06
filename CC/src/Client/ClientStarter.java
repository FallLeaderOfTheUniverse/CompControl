package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by spier on 4/6/14.
 */
public class ClientStarter {

    public void makeClient(String ip) {

        Socket fromServer = null;
        BufferedReader in = null;
        PrintWriter out = null;
        BufferedReader inu = null;
        InetAddress address = null;

        try {
            address = InetAddress.getByName(ip);
            fromServer = new Socket(address, 4444);
            in = new BufferedReader(new InputStreamReader(fromServer.getInputStream()));
            out = new PrintWriter(fromServer.getOutputStream(), true);
            inu = new BufferedReader(new InputStreamReader(System.in));

            String fuser, fserver;

            for (int i = 0; i < 10; i++) {
                out.println("blablablabla");
                wait(1000);
            }
            fserver = in.readLine();
            System.out.println(fserver);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
                inu.close();
                fromServer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
