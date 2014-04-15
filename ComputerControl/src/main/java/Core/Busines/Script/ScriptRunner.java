package Core.Busines.Script;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spier on 4/10/14.
 */
public class ScriptRunner implements Runnable{
    private String script;

    public ScriptRunner(String script) {
        this.script = script;
    }

    @Override
    public void run() {
        runScript(getScript(script));
        //return runScript(getScript(script));
    }

    private String getScript(String script) {
        CommandManager commandManager = new CommandManager(script);
        String command = null;
        try {

            command = commandManager.getCommand(script);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return command;
    }

    private List<String> runScript(String script) {
        String resultExecute;
        ArrayList<String> result = new ArrayList<String>();
        Runtime runtime = Runtime.getRuntime();

        try {
            System.out.println("inner run " + script);
            Process process = runtime.exec(new String[]{"/bin/bash", "-c", script});
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((resultExecute = bufferedReader.readLine()) != null) {
                result.add(resultExecute);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
