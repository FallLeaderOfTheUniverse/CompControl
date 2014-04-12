package Core;

import java.io.File;
import java.util.List;

/**
 * Created by spier on 4/10/14.
 */
interface ServerApi {

    public void runScript(String script);

    public String makeEcho(String echo);

    public List<File> getFiles(File file);

    public List<File> getAudio(Integer iden);

    public List<File> getVideo();
}
