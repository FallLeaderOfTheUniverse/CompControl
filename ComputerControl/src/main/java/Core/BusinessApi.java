package Core;



import Core.Busines.Managers.FileManager;
import Core.Busines.Script.ScriptRunner;

import java.io.File;
import java.util.List;

/**
 * Created by spier on 4/10/14.
 */
public class BusinessApi implements ServerApi {
    @Override
    public void runScript(String script) {
        new ScriptRunner(script).run();
    }

    @Override
    public String makeEcho(String echo) {
        return echo;
    }

    //TODO: Передаелать с использованием кеша
    @Override
    public String getFiles(File file) {
        FileManager fileManager = new FileManager(file);
        String s = "";
        for (File f : fileManager.getFiles()) {
            s += f.toString() + " ";
        }
        return s;
    }

    @Override
    public String getAudio(Integer identification) {
        //TODO: реализовать
        return null;
    }

    @Override
    public String getVideo() {
        //TODO: realize it
        return null;
    }
}
