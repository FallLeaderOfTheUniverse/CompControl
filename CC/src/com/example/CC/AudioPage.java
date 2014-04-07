package com.example.CC;

import Busines.ServerCommunication;
import Busines.ThreadForSocket;
import Client.ClientStarter;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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

        seekBar.setMax(100);
        seekBar.setProgress(55);
        new Thread(new ThreadForSocket("bash volume set " + seekBar.getProgress())).start();

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
        new Thread(new ClientStarter("localhost" ,"bash volume set " + seekBar.getProgress())).start();
    }
}
