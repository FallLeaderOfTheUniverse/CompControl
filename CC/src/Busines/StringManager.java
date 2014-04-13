package Busines;

import java.util.List;

/**
 * Created by Syomin Stas on 4/13/14.
 */
public class StringManager {

    public String[] toArray(String string) {
        return string.split(" ");
    }

    public String[] listToString(List<String> list) {
        String[] strings = null;
        int i = 0;
        for (String s : list) {
            strings[i] += s;
            i++;
        }
        return strings;
    }
}
