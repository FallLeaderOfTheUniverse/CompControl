package Garbage;

import Garbage.Script.Core.CommandManager;
import Core.Busines.Managers.StringManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
            CommandManager commandManager = new CommandManager(script);
            script = commandManager.recogniseCommand();
            System.out.println(script);
            runScript(script);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void commandRecognise(String command) throws Exception {
        StringManager stringManager = new StringManager(command);
        String name = command.substring(0, 4);
        if (name.equals("bash")) {
            //выполняем распознавание скрипка, возращается готовый скрипт, запускаем
            CommandManager commandManager = new CommandManager(command);
            String script = commandManager.getBashCommandByClientText(stringManager.stringToList());
        }
        if (name.substring(0, 4).equals("echo")) {
            //отправляем на на клиент эхо
            return command;
        }
        if (name.substring(0, 4).equals("file")) {
            //получаем список файлов в данной директории, возвращаем на клиент
            return name.substring(5);
        }

    }

    private void runcript(String script) {
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


