package com.example.CC;

import Busines.StringManager;
import Client.CallableClient;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by spier on 4/7/14.
 */
public class VideoPage extends Activity implements ServerCall {
    private ListView files;
    private String[] list = {};
    private String[] shortList = {};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);

        Button menu = (Button) findViewById(R.id.menu);
        files = (ListView) findViewById(R.id.videos);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(VideoPage.this, MainPage.class);
                startActivity(menu);
            }
        });

        files.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StringManager manager = new StringManager();
                callServer("bash video play " + manager.changeFile(list[position]));
            }
        });

        callServer("vide");
    }

    @Override
    public void refresh(String s) {
        Log.d("from filepage answer", s);
        StringManager strMan = new StringManager();
        //String [] shortList = null;
        list = strMan.rightToArray(s);
        shortList = strMan.toArrayEnd(s);
        // вывод
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listview_layout, shortList);
        files.setAdapter(adapter);
    }

    @Override
    public void callServer(String command) {
        try {
            ExecutorService ex = Executors.newCachedThreadPool();
            Future<String> s = null;
            s = ex.submit(new CallableClient(command));
            refresh(s.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
