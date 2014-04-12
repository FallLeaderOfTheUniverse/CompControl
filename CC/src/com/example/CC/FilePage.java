package com.example.CC;

import Client.ClientStarter;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spier on 4/8/14.
 */
public class FilePage extends Activity{
    List<String> folders = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.files);

        ListView files = (ListView) findViewById(R.id.files);
        files.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ClientStarter starter = new ClientStarter("192.168.1.7", "list /", folders);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listToString(folders));

        // присваиваем адаптер списку
        files.setAdapter(adapter);
    }

    private String[] listToString(List<String> list) {
        String [] strings = null;
        int i = 0;
        for (String s : list) {
            strings[i] += s;
            i++;
        }
        return strings;
    }
}
