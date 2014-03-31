import org.jdom.JDOMException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spier on 4/1/14.
 * time - 12:36 AM
 */

//TODO: убрать нафиг это кривое создание в конструкторе
public class FileManager {
    List<String> list;
    List<File> files;

    public FileManager() {
        files = new ArrayList<File>();
        XmlManager manager = new XmlManager();
        try {
            list = manager.getVideoList();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public File[] getFiles(File nowFile) {
        return nowFile.listFiles();
    }

    //TODO: внедрить сюда Spring
    public List<File> getAllVideoFiles(File root) {
        if (root.listFiles() != null)
            for (File f : root.listFiles()) {
                for (String l : list) {
                    if (f.toString().endsWith("." + l)) {
                        System.out.println(f);
                    }
                }
                if (!f.toString().contains("/.")) {
                    getAllVideoFiles(f);
                }
            }
        return files;
    }
}
