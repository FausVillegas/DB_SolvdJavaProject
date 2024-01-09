package main.java.com.solvd.database.services.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import main.java.com.solvd.database.model.Users;

import java.io.File;
import java.time.LocalDate;

public class JaxB {
    public static Users unmarshal(File file) throws Exception {
        try {
            JAXBContext jaxbContext =JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Users users = (Users) unmarshaller.unmarshal(file);
            return users;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void marshall(Users users, File file){
        try {
            JAXBContext jaxbContext =JAXBContext.newInstance(Users.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(users, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
