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
    public List<File> getFiles(File file) {
        FileManager fileManager = new FileManager(file);
        return fileManager.getFiles();
    }

    @Override
    public List<File> getAudio(Integer iden) {
        return null;
    }

    @Override
    public List<File> getVideo() {
        return null;
    }
}
