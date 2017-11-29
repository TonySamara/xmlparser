package solution.tools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {
    public static List<String> getValuesByTagName(List<File> xmlFiles, String tagname, String attribute){
        List<String> values = new ArrayList<>();
        xmlFiles.forEach(xmlFile ->{
           values.addAll(getValuesByTagNameFromSingleFle(xmlFile, tagname, attribute));
        } );
        return values;
    }

    public static List<String> getValuesByTagNameFromSingleFle(File xmlFile, String tagname, String attribute){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        List<String> valuesList = new ArrayList<>();
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            System.out.println("Корневой элемент: " + document.getDocumentElement().getNodeName());
            NodeList nodeList = document.getElementsByTagName(tagname);
            System.out.println(nodeList);
            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    valuesList.add(nodeList.item(i).getAttributes().getNamedItem(attribute).getNodeValue());
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return valuesList;
    }
}
