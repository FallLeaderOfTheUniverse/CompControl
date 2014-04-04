package Busines;

/**
 * Created by spier on 4/4/14.
 */
public class BashMaker {
    private String link;
    private String script;
    private String inner;

    public BashMaker(String link, String script, String inner) {
        this.link = link;
        this.script = script;
        this.inner = inner;
    }

    public String buildBash() throws Exception {
        Integer i1 = script.indexOf("$");
        Integer i2 = i1 + 7;
        if (!inner.equals(script.substring(i1, i2))) {
            throw new Exception("bash do not content " + inner);
        }

        return new String(script.substring(0, i1) + link + script.substring(i2));
    }
}
