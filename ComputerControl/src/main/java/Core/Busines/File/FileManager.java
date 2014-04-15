package Core.Busines.File;

import Core.Busines.Xml.XmlManager;
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

//TODO: пересмотреть весь класс, необходима большая гибкость и полиморфность
public class FileManager {
    private File file;
    private List<String> list;
    private List<File> files;

    public FileManager(File file) {
        this.file = file;
    }

    public FileManager() {}

    //содержимое folder
    //TODO: убрать скрытые папки из return
    public List<File> getFiles() {
        List<File> files = new ArrayList<File>();
        for (File f : file.listFiles()) {
            if (f.toString().indexOf("/.") == -1) {
                files.add(f);
            }
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
        System.out.println("рекурсивно достаем файлы");

        return getRecursiveFiles(files, list);
    }

    //рекурсионно достает все файлы
    private List<File> getRecursiveFiles(List<File> files, List<String> list) {
        if (file.listFiles() != null)
            for (File f : file.listFiles()) {
                for (String l : list) {
                    if (f.toString().endsWith("." + l)) {
                        files.add(f);
                        System.out.println(f.toString());
                    }
                }
                if (!f.toString().contains("/.")) {
                    getRecursiveFiles(files, list);
                }
            }
        return files;
    }

    public List<File> getFilesMusic(File file) throws JDOMException, IOException {
        files = new ArrayList<File>();
        XmlManager manager = new XmlManager();
        list = manager.getVideoList();

        return getAllFiles(file);
    }

    public List<File> getFilesVideo(File file) throws JDOMException, IOException {
        files = new ArrayList<File>();
        XmlManager manager = new XmlManager();
        list = manager.getVideoList();

        return getAllFiles(file);
    }


    private List<File> getAllFiles(File root) {
        if (root.listFiles() != null)
            for (File f : root.listFiles()) {
                for (String l : list) {
                    if (f.toString().endsWith("." + l)) {
                        files.add(f);
                    }
                }
                if (!f.toString().contains("/.")) {
                    getAllFiles(f);
                }
            }
        return files;
    }
}
