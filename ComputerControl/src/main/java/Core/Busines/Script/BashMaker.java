package Core.Busines.Script;

import java.util.List;

/**
 * Created by spier on 4/4/14.
 */
class BashMaker {
    private String body;
    private String list;
    private String teg;

    public BashMaker(String list, String body, String teg) {
        this.body = body;
        this.list = list;
        this.teg = teg;
    }

    public String buildBashByTeg() throws Exception {
        System.out.println(list + "1111111111");
        if (list.contains(teg) && teg.equals("$(PERCENT)")) {
            list = list.replace(teg, body + "%");
            System.out.println(list + "111111111");
            return list;
        }
        if (list.contains(teg)) {
            list = list.replace(teg, body);
            return list;
        }
        return null;
    }
}
