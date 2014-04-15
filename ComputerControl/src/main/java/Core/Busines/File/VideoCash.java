package Core.Busines.File;

import org.jdom.JDOMException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Syomin Stas on 4/16/14.
 */
public class VideoCash implements Cash {
    List<File> filesFromCash = null;

    @Override
    public List<File> getFiles(File file) {
        List<File> list = null;
        try {
            if (filesFromCash != null) return filesFromCash;
            if (checkFile(file)) {
                list = readFromFileCash(file);
            } else {
                list = getAllFiles();
                writeFileCash(file, list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filesFromCash = list;
    }

    private boolean checkFile(File file) {
        if (!file.exists()) return false;
        if (!file.isFile()) return false;
        if ((file.length()) == 2L) return false;
        return true;
    }

    private List<File> getAllFiles() throws JDOMException, IOException {
        //TODO: решить этот вопрос. привести к полиморфизму файлов
        File file = new File("/home/spier/");
        FileManager manager = new FileManager();
        return manager.getFilesVideo(file);
    }

    //считывает список ссылок из файла кеша созданного в этом классе
    private List<File> readFromFileCash(File file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        List<File> files = new ArrayList<File>();
        String line;
        while ((line = in.readLine()) != null) {
            files.add(new File(line));
        }
        in.close();
        return files;
    }

    //создает файл кеша и записывает туда список ссылок
    private void writeFileCash(File file, List<File> files) throws IOException {
        file.mkdir();
        FileWriter out = new FileWriter(file);
        for (File f : files) {
            out.write(f.toString() + "\n");
        }
        out.flush();
        out.close();
    }
}
