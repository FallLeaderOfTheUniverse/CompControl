package Server;

import Busines.CommandManager;
import Busines.Script;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by spier on 4/5/14.
 */

public class ServerService {

    //висит, слушает и выполняет команды. А еще он страшный.
    public void makeServer() throws Exception {
        BufferedReader in = null;
        PrintWriter out = null;

        ServerSocket servers = null;
        Socket client = null;

        try {
            System.out.println("waiting for client");
            servers = new ServerSocket(4444);
            client = servers.accept();
            System.out.println("connected");
        } catch (IOException e) {
            e.printStackTrace();
        }

        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);

        String input, output;
        while ((input = in.readLine()) != null) {
            out.println("accept");
            System.out.println(input);


            new Thread(new Script(input)).start();

            /*CommandManager command = new CommandManager(input);
            output = command.recogniseCommand();
*/
            //System.out.println(output);
        }

        System.out.println("server exit");
        out.close();
        in.close();
        client.close();
        servers.close();
    }
}