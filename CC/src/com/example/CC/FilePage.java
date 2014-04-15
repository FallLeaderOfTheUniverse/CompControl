package com.example.CC;

import Busines.StringManager;
import Client.CallableClient;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by spier on 4/8/14.
 */
public class FilePage extends Activity implements ServerCall{
    ListView files;
    String answer;
    String[] list = {};
    String [] shortList = {};
    FilePage filePage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.files);

        files = (ListView) findViewById(R.id.files);
        files.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        files.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("FILEPAGE", list[position]);
                callServer("file " + list[position]);
            }
        });

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.listview_layout, shortList);

        // присваиваем адаптер списку
        //files.setAdapter(adapter);

       callServer("file /");

    }

    @Override
    public void refresh(String s) {
        Log.d("from filepage answer", s);
        StringManager strMan = new StringManager();
        //String [] shortList = null;
        list = strMan.rightToArray(s);
        shortList = strMan.toArrayEnd(s);
        // вывод
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.listview_layout, shortList);
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
