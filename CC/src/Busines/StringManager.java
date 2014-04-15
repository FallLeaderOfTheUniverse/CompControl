package Busines;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Syomin Stas on 4/13/14.
 */
public class StringManager {

    public String[] rightToArray(String string) {
        String sub = string;
        List<String> list = new ArrayList<String>();
        while (!sub.equals("")) {
            if (sub.indexOf(" /") == -1) {
                list.add(sub);
                sub = "";
            } else {
                list.add(sub.substring(0, sub.indexOf(" /")));
                sub = sub.substring(sub.indexOf(" /") + 1);
            }
        }
        return deleteSpace(list.toArray(new String[0]));
    }

    public String[] toArrayEnd(String string) {
        String[] strings = rightToArray(string);
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].lastIndexOf("/") == -1) {
            } else {
                strings[i] = new String(strings[i].substring(strings[i].lastIndexOf("/")));
            }
        }
        return deleteSpace(strings);
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

    private String[] deleteSpace(String [] str) {
        for (int i = 0; i < str.length; i++) {
            int j = str[i].length() - 1;
            int k = str[i].indexOf(" ");
            if (j == k) {
                str[i] = str[i].substring(0, j);
            }
        }
        return str;
    }

    public String changeFile(String s) {
      return s.replace(" ", "\\ ");
    }
}
