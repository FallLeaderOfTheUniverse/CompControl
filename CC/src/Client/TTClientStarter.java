/*
package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

*/
/**
 * Created by spier on 4/6/14.
 *//*


//TODO: обеспечить устойчивость связи
public class TTClientStarter implements Runnable{
    private String ip = null;
    private String command;
    private List<String> lines = null;

    public TTClientStarter(String ip, String command) {
        this.ip = ip;
        this.command = command;
    }

    public TTClientStarter(String ip, String command, List<String> lines) {
        this.ip = ip;
        this.command = command;
        this.lines = lines;
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

            //TODO: перевести одну линию в список
            if (lines != null) {
                lines.add(fserver);
            }
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
*/
