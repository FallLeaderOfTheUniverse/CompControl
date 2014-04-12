package Core.Busines.Script;

import Core.Busines.Managers.StringManager;
import Core.Busines.Xml.XmlManager;
import org.jdom.JDOMException;

import java.io.IOException;
import java.util.List;

/**
 * Created by spier on 3/30/14.
 * time - 4:58 PM
 */

class CommandManager {
    private String command;

    public CommandManager(String command) {
        this.command = command;
    }

    public String getCommand(String command) throws Exception {
        StringManager stringManager = new StringManager(command);
        return getBashCommandByClientText(stringManager.stringToList());
    }

    private String getBashCommandByClientText(List<String> list) throws Exception {
        if (list.get(1).equals("volume")) {
            if (list.get(2).equals("set")) {
                return makeBash(list, 3, "$(PERCENT)", "volume set");
            }
            if (list.get(2).equals("mute")) {
                return makeBash("volume mute");
            }
        }
        return null;
    }

    private String makeBash(List<String> list, int i, String teg, String commandName) throws Exception{
        StringManager stringManager = new StringManager(getFromXml(commandName));
        BashMaker bashMaker = new BashMaker(stringManager.stringToList(), list.get(i), teg);

        String out = "";
        for (String s : bashMaker.buildBashByTeg()) {
            if (out.equals("")) out = s;
            else out = out + " " + s;
        }
        return out;
    }

    private String makeBash(String commandName) throws Exception{
        return getFromXml(commandName);
    }

    private String getFromXml(String in) throws JDOMException, IOException {
        XmlManager manager = new XmlManager();
        return manager.getBashMap().get(in);
    }
}
