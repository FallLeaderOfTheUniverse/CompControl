package Busines;

import ConsoleInterface.Command;
import org.jdom.JDOMException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spier on 3/30/14.
 * time - 4:58 PM
 */
public class CommandManager {
    //TODO: написать контракт для методов
    //TODO: пересмотреть этот класс, возможно разделение
    //TODO: нужен рефакторинг класса, да и всей программы
    private String command;

    public CommandManager(String command) {
        this.command = command;
    }

    public ArrayList<String> runScript() throws IOException {
        ArrayList<String> result = new ArrayList<String>();
        String resultExecute = null;
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(new String[]{"/bin/bash", "-c", command});
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        while ((resultExecute = bufferedReader.readLine()) != null) {
            result.add(resultExecute);
        }
        return result;
    }

    public String recogniseCommand() throws Exception {
        if (command.substring(0,3).equals("bash")) {
            new Thread(new CommandThread(getBashCommandByClientText(command.substring(4))));
            return "command run";
        }
        if (command.substring(0,3).equals("echo")) {
            return command;
        }
        return "wrong command";
    }

    private String getBashCommandByClientText(String in) throws Exception {
        String help = in;
        System.out.println("/" + help + "/");///
        int i = help.indexOf(" ");
        if (help.substring(0, i).equals("volume")) {
            help = help.substring(i+1);
            System.out.println("/" + help + "/");///
            i = help.indexOf(" ");
            if (help.substring(0, i).equals("set")) {
                help = help.substring(i+1);
                System.out.println("/" + help + "/");///

                BashMaker bashMaker = new BashMaker(help + "%", get("volume set"), "percent");
                return bashMaker.buildBash();
            }
        }
        return null;
    }

    //TODO: переписать имя, да у всего класса.
    private String get(String in) throws JDOMException, IOException {
        XmlManager manager = new XmlManager();
        return manager.getBashMap().get(in);
    }
}
