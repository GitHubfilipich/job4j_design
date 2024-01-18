package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        PersonalInfo personalInfo = new PersonalInfo(1,
                new Person(false, 30, new Contact("11-111"), "Worker", "Married"),
                true, "Confidential", new String[]{"fun", "joke"});
        JAXBContext context = JAXBContext.newInstance(PersonalInfo.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(personalInfo, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            PersonalInfo result = (PersonalInfo) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
