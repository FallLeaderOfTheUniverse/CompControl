import Core.Busines.Managers.FileManager;

import java.io.File;

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

        File file = new File("/home/spier/");
        FileManager fileManager = new FileManager(file);

        for (File f : fileManager.getFiles()) {
            System.out.println(f);
        }


        /*CommandManager manager = new CommandManager("bash volume set 100");
        System.out.println(manager.stringToList("bash volume set 100"));*/
    }
}
