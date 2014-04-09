import Busines.CommandManager;
import Busines.Script;
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

        /*ServerService service = new ServerService();
        try {
            service.makeServer();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        new Thread(new Script("bash volume set 100")).start();

        /*CommandManager manager = new CommandManager("bash volume set 100");
        System.out.println(manager.stringToList("bash volume set 100"));*/
    }
}
