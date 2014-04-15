/*
package Client;

import android.util.Log;
import com.example.CC.BackComm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

*/
/**
 * Created by Syomin Stas on 4/12/14.
 *//*

public class TTToServer implements Runnable {
    private final String IP = "192.168.1.7";
    private final Integer PORT = 4444;

    private String command;
    private String answer;
    private BackComm aClass;

    Socket socket = null;
    BufferedReader in = null;
    PrintWriter out = null;
    InetAddress address;

    public TTToServer(String command, String answer, BackComm aClass) {
        this.command = command;
        this.answer = answer;
        this.aClass = aClass;
    }

    @Override
    public void run() {
        */
/*//*
/создаем сокет и стримы на него
        TTSocketConnector socketConnector = new TTSocketConnector(socket, in, out);
        socketConnector.connect();
*//*

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

            //передаем данные в класс

            Log.d("class", aClass.getClass().getName());



            Log.d("Toserver", "111111111111111111111111");
            aClass.makeCall();
            Log.d("Toserver", "222222222222222222222222");
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

        Log.d(command, command);



        */
/*закрываем соединение
        socketConnector.close();*//*



    }

   */
/* public void connect() {
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
    }*//*

}
*/
