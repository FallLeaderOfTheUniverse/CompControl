package com.example.CC;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by spier on 4/8/14.
 */
public class SystemPage extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.system);

        Button menu = (Button) findViewById(R.id.menu);
        Button shutDown =(Button) findViewById(R.id.shutdown);
        Button restart = (Button) findViewById(R.id.restart);
        Button sleep = (Button) findViewById(R.id.sleep);
        Button lock = (Button) findViewById(R.id.lock);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(SystemPage.this, MainPage.class);
                startActivity(menu);
            }
        });

        shutDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
