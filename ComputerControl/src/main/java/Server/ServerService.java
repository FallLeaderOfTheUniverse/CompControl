package Server;

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

    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        PrintWriter out = null;

        ServerSocket servers = null;
        Socket client = null;

        try {
            servers = new ServerSocket(4444);
            client = servers.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
        String input, output;

        while ((input = in.readLine()) != null) {
            if (input.equalsIgnoreCase("exit")) break;
            out.println("S ::: " + input);
            System.out.println(input);
        }
        out.close();
        in.close();
        client.close();
        servers.close();
    }
}