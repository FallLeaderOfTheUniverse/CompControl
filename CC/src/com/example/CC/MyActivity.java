package com.example.CC;

import Client.ClientStarter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new ThreadClient()).start();
            }
        });
    }

    class ThreadClient implements Runnable {

        @Override
        public void run() {
            Socket fromServer = null;
            BufferedReader in = null;
            PrintWriter out = null;
            BufferedReader inu = null;
            InetAddress address = null;

            try {
                address = InetAddress.getByName("192.168.1.7");
                fromServer = new Socket(address, 4444);
                in = new BufferedReader(new InputStreamReader(fromServer.getInputStream()));
                out = new PrintWriter(fromServer.getOutputStream(), true);
                inu = new BufferedReader(new InputStreamReader(System.in));

                String fuser, fserver;

                for (int i = 0; i < 10; i++) {
                    out.println("blablablabla");
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
}


