package Core.Busines.Xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * Created by spier on 3/31/14.
 * time - 4:09 PM
 */

//TODO: make polimorf
public class XmlManager {

    //TODO: remove hardcode
    //get xml file, return map of <name, make>
    public Map<String, String> getBashMap() throws JDOMException, IOException {
        Map<String, String> map = new HashMap<String, String>();
        SAXBuilder saxBuilder = new SAXBuilder();
        File xmlFile = new File("bashScripts.xml");
        Document document = (Document) saxBuilder.build(xmlFile);

        Element rootNode = document.getRootElement();
        List list = rootNode.getChildren("bash");
        for (int i = 0; i < list.size(); i++) {
            Element node = (Element) list.get(i);
            map.put(node.getChildText("name"), node.getChildText("make"));
        }
        return map;
    }

    //TODO: remove hardcode
    //get xml file, return list of video
    public List<String> getVideoList() throws JDOMException, IOException {
        List<String> list = new ArrayList<String>();
        SAXBuilder saxBuilder = new SAXBuilder();
        File xmlFile = new File("video.xml");
        Document document = (Document) saxBuilder.build(xmlFile);

        Element rootNode = document.getRootElement();
        List listNode = rootNode.getChildren("format");
        for (int i = 0; i < listNode.size(); i++) {
            Element node = (Element) listNode.get(i);
            list.add(node.getChildText("resolution"));
        }
        return list;
    }
}



