package com.example.CC;


import Client.CallableClient;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by spier on 4/7/14.
 */
public class AudioPage extends Activity implements ServerCall{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio);

        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        Button menu = (Button) findViewById(R.id.menu);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(AudioPage.this, MainPage.class);
                startActivity(menu);
            }
        });

        seekBar.setMax(100);
        seekBar.setProgress(55);
        //new Thread(new ThreadForSocket("bash volume set " + seekBar.getProgress())).start();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                callServer("bash volume set " + seekBar.getProgress());
            }
        });

    }

    @Override
    public void refresh(String s) {

    }

    @Override
    public void callServer(String command) {
        try {
            ExecutorService ex = Executors.newCachedThreadPool();
            Future<String> s = null;
            s = ex.submit(new CallableClient(command));
            s.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
