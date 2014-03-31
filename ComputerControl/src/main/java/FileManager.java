import java.io.File;

/**
 * Created by spier on 4/1/14.
 * time - 12:36 AM
 */

public class FileManager {

    public File[] getFiles(File nowFile) {
        File file = nowFile;
        return nowFile.listFiles();
    }
}
