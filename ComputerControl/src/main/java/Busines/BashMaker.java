package Busines;

/**
 * Created by spier on 4/4/14.
 */
public class BashMaker {
    private String link;
    private String script;
    private String teg;

    public BashMaker(String link, String script, String teg) {
        this.link = link;
        this.script = script;
        this.teg = teg;
    }

    public String buildBash() throws Exception {
        Integer i1 = script.indexOf("$");
        Integer i2 = i1 + teg.length() + 3;
        System.out.println(script.substring(i1, i2));
        if (!teg.equalsIgnoreCase(script.substring(i1+2, i2-1))) {
            throw new Exception("bash do not content " + teg);
        }

        String out = script.substring(0, i1) + link + script.substring(i2);
        System.out.println(out);
        return out;
    }
}
