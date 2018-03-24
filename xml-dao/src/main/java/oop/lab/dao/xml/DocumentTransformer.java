package oop.lab.dao.xml;

import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;

/**
 * Created by Евгений on 24.03.2018.
 */
public class DocumentTransformer {

    public static <T> Document objectToDocument (T object, Class<T> type) throws JAXBException, ParserConfigurationException {
        JAXBContext jc = JAXBContext.newInstance(type);

        // Create the Document
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.newDocument();

        // Marshal the Object to a Document
        Marshaller marshaller = jc.createMarshaller();
        marshaller.marshal(object, document);
        return document;
    }

    public static <T> T documentToObject (Document document, Class<T> type) throws JAXBException, ParserConfigurationException {
        JAXBContext context = JAXBContext.newInstance(type);
        DOMSource source = new DOMSource(document);
        T object = (T) JAXBIntrospector.getValue(context.createUnmarshaller().unmarshal(source));
        return object;
    }

    public static Document transformXML(Document xml, Document xslt) throws TransformerException {

        Source xmlSource = new DOMSource(xml);
        Source xsltSource = new DOMSource(xslt);
        DOMResult result = new DOMResult();

        // the factory pattern supports different XSLT processors
        TransformerFactory transFact
                = TransformerFactory.newInstance();
        Transformer trans = transFact.newTransformer(xsltSource);

        trans.transform(xmlSource, result);

        Document resultDoc = (Document) result.getNode();

        return resultDoc;
    }
}
