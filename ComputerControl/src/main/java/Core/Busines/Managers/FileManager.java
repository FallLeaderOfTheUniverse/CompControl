package Core.Busines.Managers;

import Core.Busines.Xml.XmlManager;
import com.sun.deploy.util.ArrayUtil;
import org.jdom.JDOMException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spier on 4/1/14.
 * time - 12:36 AM
 */

public class FileManager {
    private File file;

    public FileManager(File file) {
        this.file = file;
    }

    //содержимое folder
    //TODO: убрать скрытые папки из return
    public List<File> getFiles() {
        List<File> files = new ArrayList<File>();
        for (File f : file.listFiles()) {
            files.add(f);
        }
        return files;
    }

    public void makeFile(List<String> list) throws IOException {
        FileWriter out = new FileWriter(file);
        for (String s : list) {
            out.write(s + "\n");
        }
        out.flush();
        out.close();
    }

    //TODO: внедрить сюда Spring
    public List<File> getFilesByEnd() throws JDOMException, IOException {
        List<File> files = new ArrayList<File>();
        XmlManager manager = new XmlManager();
        List<String> list = manager.getVideoList();

        return getRecursiveFiles(files, list);
    }

    //тут рекурсия? возвращает все видео файлы
    //да...это рекурсия(
    //рекурсионно достает все файлы
    private List<File> getRecursiveFiles(List<File> files, List<String> list) {
        if (file.listFiles() != null)
            for (File f : file.listFiles()) {
                for (String l : list) {
                    if (f.toString().endsWith("." + l)) {
                        files.add(f);
                    }
                }
                if (!f.toString().contains("/.")) {
                    getRecursiveFiles(files, list);
                }
            }
        return files;
    }
}