package Core.Busines.File;

import java.io.File;
import java.util.List;

/**
 * Created by Syomin Stas on 4/16/14.
 */
public interface Cash {

    /**берет из кеша файлы и отдает
     *
     * @return лист файлов
     */
    public List<File> getFiles(File file);
}
