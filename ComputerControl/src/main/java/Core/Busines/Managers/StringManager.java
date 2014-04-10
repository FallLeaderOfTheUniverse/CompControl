package Core.Busines.Managers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spier on 4/7/14.
 */
public class StringManager {
    private String string;

    public StringManager(String string) {
        this.string = string;
    }

    public List<String> stringToList() {
        List<String> strings = new ArrayList<String>();
        while (!string.equals("")) {
            int i = string.indexOf(" ");
            if (i == (-1)) {
                strings.add(string);
                return strings;
            }
            strings.add(string.substring(0, i));
            string = string.substring(i + 1);
        }
        return strings;
    }
}
