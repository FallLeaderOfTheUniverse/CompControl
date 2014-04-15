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
        System.out.println("commandmanager " + command);
        return getBashCommandByClientText(command);
    }

    private String getBashCommandByClientText(String list) throws Exception {
        if (list.contains("volume set")) {
            return makeBash(list, "$(PERCENT)" , "volume set", new String("volume set").length());
        }
        if (list.contains("video play")) {
            return makeBash(list, "$(LINK)", "video play", new String("video play").length());
        }
        if (list.contains("music play")) {
            return makeBash(list, "(LINK)", "music play", new String("music play.").length());
        }
        return null;
    }

    private String makeBash(String list, String teg, String commandName, int i) throws Exception{
        //StringManager stringManager = new StringManager(getFromXml(commandName));

        BashMaker bashMaker = new BashMaker(getFromXml(commandName), list.substring(i), teg);
        return bashMaker.buildBashByTeg();
    }

    private String makeBash(String commandName) throws Exception{
        return getFromXml(commandName);
    }

    private String getFromXml(String in) throws JDOMException, IOException {
        XmlManager manager = new XmlManager();
        return manager.getBashMap().get(in);
    }
}
