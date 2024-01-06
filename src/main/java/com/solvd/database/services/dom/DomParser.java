package main.java.com.solvd.database.services.dom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomParser {
    private static final Logger LOGGER = LogManager.getLogger(DomParser.class);

    public static void usersXml(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("src/main/resources/users.xml");
            NodeList userList = doc.getElementsByTagName("user");
            for (int i = 0; i < userList.getLength(); i++) {
                Node p = userList.item(i);
                if (p.getNodeType() == Node.ELEMENT_NODE) {
                    Element match = (Element) p;
                    String id = match.getAttribute("id");
                    NodeList tables = match.getChildNodes();
                    for (int j = 0; j < tables.getLength(); j++) {
                        Node n = tables.item(j);
                        if (n.getNodeType() == Node.ELEMENT_NODE) {
                            Element name = (Element) n;
                            LOGGER.info("User " + id + ": " +
                                    name.getTagName() + "=" + name.getTextContent());
                        }
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
