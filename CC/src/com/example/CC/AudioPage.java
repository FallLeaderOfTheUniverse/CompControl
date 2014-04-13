package com.example.CC;

import Client.TTClientStarter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

/**
 * Created by spier on 4/7/14.
 */
public class AudioPage extends Activity implements SeekBar.OnSeekBarChangeListener{

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

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        new Thread(new TTClientStarter("localhost" ,"bash volume set " + seekBar.getProgress())).start();
    }
}
