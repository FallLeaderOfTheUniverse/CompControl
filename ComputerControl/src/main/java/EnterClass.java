import Busines.CommandManager;
import ConsoleInterface.Command;
import ConsoleInterface.ConsoleInterfaceStarter;
import Server.ServerService;
import org.jdom.JDOMException;

import java.io.IOException;
import java.util.Map;

/**
 * Created by spier on 3/31/14.
 * time - 4:41 PM
 */
public class EnterClass {
    public static void main(String[] args) throws Exception {

        ServerService service = new ServerService();
        try {
            service.makeServer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*CommandManager manager = new CommandManager("bash volume set 100");
        System.out.println(manager.recogniseCommand());*/

                /*CommandManager manager = new CommandManager("amixer sset -q Master 100%");
        manager.runScript();*/

        /*CommandManager commandManager = new CommandManager("volume set 50");
        System.out.println(commandManager.getBashCommandByClientText());*/
    }
}
