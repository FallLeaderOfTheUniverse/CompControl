import org.jdom.JDOMException;

import java.io.IOException;
import java.util.Map;

/**
 * Created by spier on 3/31/14.
 * time - 4:41 PM
 */
public class EnterClass {
    public static void main(String[] args) {
        XmlManager xmlManager = new XmlManager();
        Map<String,String>  map = null;
        try {
            map = xmlManager.getBashMap();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, String> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + "/   " + entry.getValue());
        }
    }
}
