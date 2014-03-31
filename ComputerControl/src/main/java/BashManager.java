import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spier on 3/30/14.
 * time - 4:58 PM
 */
public class BashManager {
    //TODO: написать контракт для методов
    public static void main(String[] args) {
        BashManager bashManager = new BashManager();
        try {
           List<String> list = bashManager.runScript("ifconfig");
            for (String a : list) {
                System.out.println(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> runScript(String command) throws IOException {
        ArrayList<String> result = new ArrayList<String>();
        String resultExecute = null;
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(new String[]{"/bin/bash", "-c", command});
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        while ((resultExecute = bufferedReader.readLine()) != null) {
            result.add(resultExecute);
        }
        return result;
    }
}
