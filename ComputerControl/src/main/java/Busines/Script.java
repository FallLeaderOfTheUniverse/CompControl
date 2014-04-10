package Busines;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spier on 4/7/14.
 */
public class Script implements Runnable {
    private String script;

    public Script(String script) {
        this.script = script;
    }

    @Override
    public void run() {
        try {
            CommandManager manager = new CommandManager(script);
            script = manager.recogniseCommand();
            System.out.println(script);
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        String resultExecute;
        ArrayList<String> result = new ArrayList<String>();
        Runtime runtime = Runtime.getRuntime();

        try {
            Process process = runtime.exec(new String[]{"/bin/bash", "-c", script});
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((resultExecute = bufferedReader.readLine()) != null) {
                result.add(resultExecute);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

