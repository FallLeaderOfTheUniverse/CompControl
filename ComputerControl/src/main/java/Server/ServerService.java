package Server;




import Core.Chooser;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by spier on 4/5/14.
 */

public class ServerService implements Server {

    //висит, слушает и выполняет команды. А еще он страшный.
    @Override
    public void startServer() {
        BufferedReader in = null;
        PrintWriter out = null;
        ServerSocket servers = null;
        Socket client = null;

        try {
            System.out.println("waiting for client");
            servers = new ServerSocket(4444);
            client = servers.accept();
            System.out.println("connected");

            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);

            String input = "", output;
            while (!input.equals("end")) {
                input = in.readLine();
                out.println("accept");
                System.out.println(input);

                Chooser chooser = new Chooser();
                String s = chooser.commandRecognise(input);
                out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("server exit");
            try {
                out.close();
                in.close();
                client.close();
                servers.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}