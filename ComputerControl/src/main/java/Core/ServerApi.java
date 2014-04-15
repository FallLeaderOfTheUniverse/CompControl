package Core;

import java.io.File;
import java.util.List;

/**
 * Created by spier on 4/10/14.
 */
interface ServerApi {

    public void runScript(String script);

    public String makeEcho(String echo);

    public String getFiles(File file);

    public String getAudio();

    public String getVideo();
}
