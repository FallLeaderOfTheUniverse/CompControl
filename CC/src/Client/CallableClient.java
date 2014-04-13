package Client;

import android.util.Log;
import com.example.CC.BackComm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.Callable;

/**
 * Created by Syomin Stas on 4/13/14.
 */
public class CallableClient implements Callable<String> {
    private final String IP = "192.168.1.7";
    private final Integer PORT = 4444;

    private String command;
    private String answer;

    Socket socket = null;
    BufferedReader in = null;
    PrintWriter out = null;
    InetAddress address;

    public CallableClient(String command) {
        this.command = command;
    }

    @Override
    public String call() throws Exception {
        try {
            address = InetAddress.getByName(IP);
            socket = new Socket(address, PORT);

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            //отправляем команду
            out.println(command);

            //читаем ответ
            answer = in.readLine();
            while (answer.equals("accept")) {
                answer = in.readLine();
            }
            Log.d("answer", answer);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                in.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return answer;
    }
}
