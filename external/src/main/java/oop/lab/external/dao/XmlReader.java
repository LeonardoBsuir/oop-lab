package oop.lab.external.dao;

import oop.lab.external.model.Rights;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.TransformerException;
import java.io.File;

/**
 * Created by Евгений on 24.03.2018.
 */
@Component
public class XmlReader {

    public Rights readFromFile (File file) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Rights.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Rights rights = (Rights) jaxbUnmarshaller.unmarshal(file);
        return rights;
    }

    public void writeToFile (File file, Rights rights) throws TransformerException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Rights.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(rights, file);

    }
}
