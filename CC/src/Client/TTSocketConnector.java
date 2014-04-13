package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

/**
 * Created by Syomin Stas on 4/12/14.
 */

//создает сокет и стримы на нем
class TTSocketConnector {
    //TODO: убрать хардкод
    private final String IP = "192.168.1.7";
    private final Integer PORT = 4444;

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private InetAddress address;

    public TTSocketConnector(Socket socket, BufferedReader in, PrintWriter out) {
        this.socket = socket;
        this.in = in;
        this.out = out;
    }

    public void connect() {
        try {
            address = InetAddress.getByName(IP);
            socket = new Socket(address, PORT);

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            socket.close();
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

