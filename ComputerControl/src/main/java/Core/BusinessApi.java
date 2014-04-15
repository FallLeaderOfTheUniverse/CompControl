package Core;


import Core.Busines.File.FileManager;
import Core.Busines.Script.ScriptRunner;

import java.io.File;

/**
 * Created by spier on 4/10/14.
 */
public class BusinessApi implements ServerApi {
    @Override
    public void runScript(String script) {
        new Thread(new ScriptRunner(script)).start();
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
    public String getAudio() {
        FileManager manager = new FileManager(new File("/"));
        String s = "";
        File file = new File("/home/spier/");

        try {
            for (File f : manager.getFilesMusic(file)) {
                s += f.toString() + " ";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public String getVideo() {
        FileManager manager = new FileManager(new File("/"));
        String s = "";
        File file = new File("/home/spier/");

        try {
            for (File f : manager.getFilesVideo(file)) {
                s += f.toString() + " ";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
