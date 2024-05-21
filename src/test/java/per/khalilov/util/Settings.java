package per.khalilov.util;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Settings {
    public static String file = "Settings.xml";
    public static String baseUrl;
    public static String username;
    public static String password;

    static  {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            baseUrl = document.getElementsByTagName("baseUrl").item(0).getTextContent();
            username = document.getElementsByTagName("username").item(0).getTextContent();
            password = document.getElementsByTagName("password").item(0).getTextContent();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
