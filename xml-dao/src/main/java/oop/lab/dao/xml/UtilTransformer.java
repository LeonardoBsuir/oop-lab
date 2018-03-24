package oop.lab.dao.xml;

import oop.lab.common.model.Role;
import oop.lab.common.model.Roles;
import oop.lab.external.model.Rights;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

/**
 * Created by Евгений on 24.03.2018.
 */
public class UtilTransformer {

    private final static String RIGHT_XSLT = "D:/Univer/test/src/main/resources/xslt/rightToRole.xslt";
    private final static String ROLE_XSLT = "D:/Univer/test/src/main/resources/xslt/roleToRight.xslt";

    public static List<Role> rightsToRoles (Rights rights) throws JAXBException, ParserConfigurationException, IOException, SAXException, TransformerException {
        Document documentRights = DocumentTransformer.objectToDocument(rights, Rights.class);
        Document documentRoles = DocumentTransformer.transformXML(documentRights, createXslt(RIGHT_XSLT));
        Roles roles = DocumentTransformer.documentToObject(documentRoles, Roles.class);
        return roles.getRoles();
    }

    public static Rights rolesToRights (Roles roles) throws JAXBException, ParserConfigurationException, IOException, SAXException, TransformerException {
        Document documentRoles = DocumentTransformer.objectToDocument(roles, Roles.class);
        Document documentRights = DocumentTransformer.transformXML(documentRoles, createXslt(ROLE_XSLT));
        Rights rights = DocumentTransformer.documentToObject(documentRights, Rights.class);
        return rights;
    }

    private static Document createXslt(String path) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document xslt = db.parse(path);
        return xslt;
    }
}
