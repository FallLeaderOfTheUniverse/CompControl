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
        new Thread(new ClientStarter("localhost" ,"bash volume set " + seekBar.getProgress())).start();

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //NOP
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //NOP
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Log.d("audioPage" ,"считалось");
        new Thread(new ClientStarter("localhost" ,"bash volume set " + seekBar.getProgress())).start();
    }
}
