package Busines;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by spier on 4/7/14.
 */
//TODO: нужен ли вообще этот пакет?
public class SingletonSocket {
    private static Socket instance;

    public static Socket getInstance(InetAddress ip, Integer port) throws IOException {
        if (instance == null) {
            instance = new Socket(ip, port);
        }
        return instance;
    }
}

