package Core.Busines.Script.Core;

import java.util.List;

/**
 * Created by spier on 4/4/14.
 */
public class BashMaker {
    private String body;
    private List<String> list;
    private String teg;

    public BashMaker(List<String> list,String body, String teg) {
        this.body = body;
        this.list = list;
        this.teg = teg;
    }

    public List<String> buildBashByTeg() throws Exception {
        int i = 0;
        for (String s : list) {
            if (s.equalsIgnoreCase(teg)) break;
            i++;
        }
        list.set(i, body + "%");
        return list;
    }
}
