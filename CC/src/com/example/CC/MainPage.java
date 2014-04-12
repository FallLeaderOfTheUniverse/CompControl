package com.example.CC;

import Busines.ThreadForSocket;
import Client.ClientStarter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MainPage extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Button audio = (Button) findViewById(R.id.audio);
        final Button video = (Button) findViewById(R.id.video);
        final Button system = (Button) findViewById(R.id.system);
        final Button files = (Button) findViewById(R.id.files);

        audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent audio = new Intent(MainPage.this, AudioPage.class);
                startActivity(audio);
            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent video = new Intent(MainPage.this, VideoPage.class);
                startActivity(video);
            }
        });

        system.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent system = new Intent(MainPage.this, SystemPage.class);
                startActivity(system);
            }
        });

        files.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent files = new Intent(MainPage.this, FilePage.class);
                startActivity(files);
            }
        });
    }
}

